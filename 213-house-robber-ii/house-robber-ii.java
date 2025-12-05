class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        Integer[] dp1 = new Integer[n];
        int case1 = solve(nums, 0, n - 2, dp1);

        Integer[] dp2 = new Integer[n];
        int case2 = solve(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    private int solve(int[] nums, int i, int j, Integer[] dp) {
        if (i > j) return 0;

        if (dp[i] != null) return dp[i];

        int take = nums[i] + solve(nums, i + 2, j, dp);
        int notTake = solve(nums, i + 1, j, dp);

        return dp[i] = Math.max(take, notTake);
    }
}
