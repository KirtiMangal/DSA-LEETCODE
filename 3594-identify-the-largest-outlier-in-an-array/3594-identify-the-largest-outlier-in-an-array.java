class Solution {
    public boolean binarySearch(int[] nums, double target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return false;
    }

    public int getLargestOutlier(int[] nums) {
        Arrays.sort(nums); 

        int totalSum = Arrays.stream(nums).sum();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) 
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            double potentialSum = (totalSum - nums[i]) / 2.0;

            if (binarySearch(nums, potentialSum)) 
            {
                if ((potentialSum == nums[i] && freq.get(nums[i]) >= 2) || potentialSum != nums[i]) 
                {
                    return nums[i];
                }
            }
        }

        return 0;
    }
}