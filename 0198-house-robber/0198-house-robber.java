// class Solution {
//     public int rob(int[] nums) {
//         int n= nums.length;
//         int prev2=0;
//         int prev1=0;

//         for(int i=0;i<n;i++){
//             int max= Math.max(prev1, prev2+nums[i]);
//             prev2= prev1;
//             prev1= max;
//         }

//         return prev1;
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp= new int[n+2];

        for(int i=n-1;i>=0;i--){
            int take= nums[i]+ dp[i+2];
            int nottake= dp[i+1];

            dp[i]= Math.max(take,nottake);
        }

        return dp[0];
    }}