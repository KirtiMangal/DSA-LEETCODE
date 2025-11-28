class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adj[node1].add(node2);
            adj[node2].add(node1);
        }

        int[] count = new int[1];
        dfs(0, -1, adj, values, k, count);
        return count[0];
    }

    public static long dfs(int current, int parent, List<Integer>[] adj, int[] values, int k, int[] count) {
        long sum = 0;

        for (int neighbour : adj[current]) {
            if (neighbour != parent) {
                sum += dfs(neighbour, current, adj, values, k, count);
            }
        }

        sum += values[current];

        if (sum % k == 0) {
            count[0]++;
            return 0;
        }

        return sum;
    }
}
