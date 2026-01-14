import java.util.*;

class Solution {

    static class Event {
        long y;
        int x1, x2;
        int type; // +1 add, -1 remove

        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int n;
        int[] count;
        long[] length;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[4 * n];
            length = new long[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) 
            return;

            if (ql <= l && r <= qr) {
                count[node] += val;
            } 
            
            else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } 
            
            else if (l + 1 == r) {
                length[node] = 0;
            } 
            
            else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }

        long query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;

        List<Long> xsList = new ArrayList<>();
        List<Event> events = new ArrayList<>();

        // Collect x-coordinates
        for (int[] s : squares) {
            xsList.add((long) s[0]);
            xsList.add((long) s[0] + s[2]);
        }

        // Coordinate compression
        Collections.sort(xsList);
        Map<Long, Integer> index = new HashMap<>();
        int idx = 0;
        for (long x : xsList) {
            if (!index.containsKey(x)) {
                index.put(x, idx++);
            }
        }

        long[] xs = new long[index.size()];
        for (Map.Entry<Long, Integer> e : index.entrySet()) {
            xs[e.getValue()] = e.getKey();
        }

        // Build events
        for (int[] s : squares) {
            long x1 = s[0];
            long x2 = (long) s[0] + s[2];
            long y1 = s[1];
            long y2 = (long) s[1] + s[2];

            events.add(new Event(y1, index.get(x1), index.get(x2), +1));
            events.add(new Event(y2, index.get(x1), index.get(x2), -1));
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        long prevY = events.get(0).y;
        List<long[]> segments = new ArrayList<>();
        double totalArea = 0;

        // Sweep line
        for (Event e : events) {
            long currY = e.y;
            long width = st.query();

            if (currY > prevY && width > 0) {
                segments.add(new long[]{prevY, currY, width});
                totalArea += width * (currY - prevY);
            }

            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = currY;
        }

        // Find minimum y where area >= half
        double half = totalArea / 2.0;
        double acc = 0;

        for (long[] seg : segments) {
            double area = (seg[1] - seg[0]) * seg[2];
            
            if (acc + area >= half) {
                return seg[0] + (half - acc) / seg[2];
            }
            acc += area;
        }

        return 0.0;
    }
}
