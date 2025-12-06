import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        // dp[i] = ways for first i elements (i from 0..n), dp[0]=1
        long[] dp = new long[n + 1];
        long[] pre = new long[n + 1]; // pre[i] = sum(dp[0..i])
        dp[0] = 1;
        pre[0] = 1;

        Deque<Integer> maxDeque = new ArrayDeque<>(); // indices, decreasing values
        Deque<Integer> minDeque = new ArrayDeque<>(); // indices, increasing values

        int L = 0; // left pointer (0-based)
        for (int i = 0; i < n; ++i) {
            // push nums[i] into maxDeque (monotonic decreasing)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[i]) maxDeque.pollLast();
            maxDeque.offerLast(i);
            // push nums[i] into minDeque (monotonic increasing)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[i]) minDeque.pollLast();
            minDeque.offerLast(i);

            // move L forward while window [L..i] invalid
            while (L <= i && nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                // increment L and pop outdated indices
                L++;
                if (!maxDeque.isEmpty() && maxDeque.peekFirst() < L) maxDeque.pollFirst();
                if (!minDeque.isEmpty() && minDeque.peekFirst() < L) minDeque.pollFirst();
            }

            // Now window [L..i] is valid. dp[i+1] = sum(dp[L..i]) = pre[i] - pre[L-1]
            long total = pre[i] - (L - 1 >= 0 ? pre[L - 1] : 0);
            total %= MOD;
            if (total < 0) total += MOD;
            dp[i + 1] = total;
            pre[i + 1] = (pre[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }

    // For LeetCode style method name:
    public int countPartitionsMain(int[] nums, int k) {
        return countPartitions(nums, k);
    }

    // Example usage
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPartitions(new int[]{9,4,1,3,7}, 4)); // 6
        System.out.println(s.countPartitions(new int[]{3,3,4}, 0)); // 2
    }
}
