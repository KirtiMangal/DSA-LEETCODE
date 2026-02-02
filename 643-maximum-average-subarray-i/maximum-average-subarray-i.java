class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        long sum = 0; // use long to avoid overflow

        // Sum first k elements
        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }

        long maxSum = sum;

        // Slide window
        for (int i = 0; i < n - k; i++) {
            sum = sum - nums[i] + nums[i + k];  // remove left, add new
            maxSum = Math.max(maxSum, sum);     // update max
        }

        return (double) maxSum / k; // return average
    }
}
