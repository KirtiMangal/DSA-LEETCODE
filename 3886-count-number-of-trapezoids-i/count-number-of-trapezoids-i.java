import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1_000_000_007L;

        // 1) Count how many points lie on each horizontal line (each y)
        Map<Integer, Integer> countByY = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            countByY.put(y, countByY.getOrDefault(y, 0) + 1);
        }

        // 2) For each y-level compute number of horizontal segments = C(n,2)
        //    Collect these values into a list in any order (we'll combine them pairwise)
        List<Long> segmentsPerLevel = new ArrayList<>();
        for (int cnt : countByY.values()) {
            if (cnt >= 2) {
                long seg = (long) cnt * (cnt - 1) / 2L;
                segmentsPerLevel.add(seg % MOD);
            } else {
                segmentsPerLevel.add(0L);
            }
        }

        // 3) Sum product of all pairs of levels: sum_{i<j} seg[i]*seg[j]
        //    Use prefix sum to do it in one pass:
        long prefix = 0L;
        long answer = 0L;
        for (long seg : segmentsPerLevel) {
            answer = (answer + prefix * seg) % MOD;
            prefix = (prefix + seg) % MOD;
        }

        return (int) answer;
    }
}
