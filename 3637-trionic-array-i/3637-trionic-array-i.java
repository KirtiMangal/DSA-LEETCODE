class Solution {

    public boolean isTrionic(int[] nums) {
        int n = nums.length;

        // p splits first & second, q splits second & third
        for (int p = 1; p <= n - 3; p++) {
            for (int q = p + 1; q <= n - 2; q++) {

                if (isIncreasing(nums, 0, p) &&
                    isDecreasing(nums, p, q) &&
                    isIncreasing(nums, q, n - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    // check strictly increasing from l to r
    private boolean isIncreasing(int[] nums, int l, int r) {
        for (int i = l; i < r; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // check strictly decreasing from l to r
    private boolean isDecreasing(int[] nums, int l, int r) {
        for (int i = l; i < r; i++) {
            if (nums[i] <= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
