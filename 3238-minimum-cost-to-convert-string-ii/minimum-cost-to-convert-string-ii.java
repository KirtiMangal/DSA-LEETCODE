import java.util.*;

class Solution {
    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost
    ) {
        int n = source.length();
        final long INF = (long) 1e18;

        // 1. Collect all unique strings
        Set<String> set = new HashSet<>();
        for (String s : original) set.add(s);
        for (String s : changed) set.add(s);

        List<String> list = new ArrayList<>(set);
        int m = list.size();

        Map<String, Integer> id = new HashMap<>();
        for (int i = 0; i < m; i++) id.put(list.get(i), i);

        // 2. Collect valid lengths
        Set<Integer> validLengths = new HashSet<>();
        for (String s : list) validLengths.add(s.length());

        // 3. Floyd–Warshall init
        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // 4. Floyd–Warshall
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 5. DP
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            // character match
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            // substring transformations (OPTIMIZED)
            for (int len : validLengths) {
                if (i + len > n) continue;

                String sSub = source.substring(i, i + len);
                String tSub = target.substring(i, i + len);

                Integer u = id.get(sSub);
                Integer v = id.get(tSub);

                if (u != null && v != null && dist[u][v] != INF) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + dist[u][v]);
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }
}
