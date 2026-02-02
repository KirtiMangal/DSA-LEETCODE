class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        long sum = 0; 

        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }

        long maxSum = sum;

        for (int i = 0; i < n - k; i++) {
            sum = sum - nums[i] + nums[i + k];  
            maxSum = Math.max(maxSum, sum);  
        }

        return (double) maxSum / k;
    }
}
