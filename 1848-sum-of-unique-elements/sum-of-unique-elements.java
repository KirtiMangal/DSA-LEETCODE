class Solution {
    public int sumOfUnique(int[] nums) {
        int n= nums.length;
        int sum=0;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            // if((i==0 || nums[i]!=nums[i-1]) && (i==n-1 || nums[i]!=nums[i+1])){
                if((i==0 || nums[i]!=nums[i-1]) && (i==n-1 || nums[i]!=nums[i+1])){
                sum+=nums[i];
            }
        }
        
        return sum;
    }
}