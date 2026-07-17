// class Solution {
//     public int rob(int[] nums) {
//         int n= nums.length;
//         int prev2=0;
//         int prev1=0;

//         for(int i=0;i<n;i++){
//             int max= Math.max(prev1,prev2+nums[i]);
//             prev2=prev1;
//             prev1=max;
//         }

//         return prev1;
//     }
// }

// class Solution {
//     public int rob(int[] nums) {

//         int n = nums.length;

//         if (n == 1)
//             return nums[0];

//         return Math.max(
//             solve(nums, 0, n - 2), // Exclude last house
//             solve(nums, 1, n - 1)  // Exclude first house
//         );
//     }

//     private int solve(int[] nums, int start, int end) {

//         int prev2 = 0;
//         int prev1 = 0;

//         for (int i = start; i <= end; i++) {

//             int curr = Math.max(prev1, prev2 + nums[i]);

//             prev2 = prev1;
//             prev1 = curr;
//         }

//         return prev1;
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n= nums.length;

        if(n==1){
            return nums[0];
        }

        Integer[] dp1= new Integer[n];
        int case1= solve(nums,0,n-2,dp1);

        Integer[] dp2= new Integer[n];
        int case2= solve(nums,1,n-1,dp2);

        return Math.max(case1,case2);
    }


        private int solve(int[] nums, int start, int end, Integer[] dp){
            if(start>end){
                return 0;
            }

            if(dp[start]!=null){
                return dp[start];
            }

            int take= nums[start]+ solve(nums,start+2,end,dp);
            int nottake= solve(nums,start+1,end,dp);

            dp[start]= Math.max(take,nottake);

            return dp[start];
        }
        }
