class Solution {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(n - 1, amount, coins, dp);

        return ans >= (int)1e9 ? -1 : ans;
    }

    public int solve(int ind, int target, int[] coins, int[][] dp) {

        // Base Case
        if (ind == 0) {

            if (target % coins[0] == 0)
                return target / coins[0];

            return (int)1e9;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        // Don't take current coin
        int notTake = solve(ind - 1, target, coins, dp);

        // Take current coin
        int take = (int)1e9;

        if (coins[ind] <= target) {
            take = 1 + solve(ind, target - coins[ind], coins, dp);
        }

        return dp[ind][target] = Math.min(take, notTake);
    }
}