import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] pre = new long[n + 1]; 
        dp[0] = 1;
        pre[0] = 1;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int L = 0; 
        for (int i = 0; i < n; ++i) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[i]) maxDeque.pollLast();
            maxDeque.offerLast(i);
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[i]) minDeque.pollLast();
            minDeque.offerLast(i);

            while (L <= i && nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                L++;
                if (!maxDeque.isEmpty() && maxDeque.peekFirst() < L) maxDeque.pollFirst();
                if (!minDeque.isEmpty() && minDeque.peekFirst() < L) minDeque.pollFirst();
            }

            long total = pre[i] - (L - 1 >= 0 ? pre[L - 1] : 0);
            total %= MOD;
            if (total < 0) total += MOD;
            dp[i + 1] = total;
            pre[i + 1] = (pre[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }

    public int countPartitionsMain(int[] nums, int k) {
        return countPartitions(nums, k);
    }
}
