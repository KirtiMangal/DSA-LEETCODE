class Solution {
    public int minPairSum(int[] nums) {
        int n= nums.length;
        //int max=0;
        int max= Integer.MIN_VALUE;
        Arrays.sort(nums);

        for(int i=0;i<=n/2;i++){
            max= Math.max(max, nums[i]+ nums[n-i-1]);
        }

        return max;
    }
}