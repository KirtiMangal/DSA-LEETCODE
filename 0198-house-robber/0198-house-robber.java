class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        Integer[] dp= new Integer[n];
        return solve(nums,0,dp);
        
    }

private int solve(int[] nums,int i,Integer[] dp){
    int n= nums.length;
    if(i>=n){
        return 0;
    }

    if(dp[i]!=null){
        return dp[i];
    }

    int take= nums[i]+ solve(nums,i+2,dp);
    int nottake= solve(nums,i+1,dp);

    dp[i]=  Math.max(take,nottake);

    return dp[i];
}
}