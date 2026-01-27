import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {

        List<int[]>[] out = new ArrayList[n];
        List<int[]>[] in = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            out[i] = new ArrayList<>();
            in[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            out[e[0]].add(new int[]{e[1], e[2]});
            in[e[1]].add(new int[]{e[0], e[2]});
        }

        long INF = (long) 1e18;
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], INF);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0][0] = 0;
        pq.add(new long[]{0, 0, 0}); // cost, node, usedSwitch

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cost = cur[0];
            int u = (int) cur[1];
            int used = (int) cur[2];

            if (cost > dist[u][used]) continue;

            // normal edges
            for (int[] e : out[u]) {
                int v = e[0], w = e[1];
                if (dist[v][0] > cost + w) {
                    dist[v][0] = cost + w;
                    pq.add(new long[]{dist[v][0], v, 0});
                }
            }

            // reverse edges (switch of THIS node only)
            if (used == 0) {
                for (int[] e : in[u]) {
                    int v = e[0], w = e[1];
                    long newCost = cost + 2L * w;
                    if (dist[v][0] > newCost) {
                        dist[v][0] = newCost;
                        pq.add(new long[]{newCost, v, 0}); // 🔥 FIX
                    }
                }
            }
        }

        long ans = dist[n - 1][0];
        return ans == INF ? -1 : (int) ans;
    }
}
