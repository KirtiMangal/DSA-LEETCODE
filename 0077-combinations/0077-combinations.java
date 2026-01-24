class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k, new ArrayList<>());
        return res;
    }

    void dfs(int start, int n, int k, List<Integer> cur) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(i + 1, n, k, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
