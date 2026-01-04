class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        // find search space
        for (int num : nums) {
            low = Math.max(low, num); // max element
            high += num;              // total sum
        }

        // binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid - 1; // try smaller maximum sum
            } else {
                low = mid + 1;  // need bigger sum
            }
        }

        return low;
    }

    // helper function
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return subarrays <= k;
    }
}
