class Solution {
    public int rob(int[] nums) {
        int n= nums.length;

        int prev2=0;
        int prev1=0;

        for(int i=0;i<n;i++){
            int max= Math.max(prev1, prev2+nums[i]);
            prev2= prev1;
            prev1= max;
        }

        return prev1;


    }
}