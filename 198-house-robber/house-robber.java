// class Solution {
//     public int rob(int[] nums) {
//         int n= nums.length;
//         if(nums==null || n==0){
//             return 0;
//         }

//         if(n==1){
//             return nums[0];
//         }

//         int prev2=0;
//         int prev1=0;

//         for(int i=0;i<n;i++){
//             int max= Math.max(prev1, nums[i]+prev2);
//             prev2= prev1;
//             prev1=max;
//         }

//         return prev1;
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int prev1=nums[0];
        int prev2=0;

        for(int i=1;i<n;i++){
            int take= prev2+nums[i];
            int nottake= prev1;

            int max= Math.max(take,nottake);

            prev2=prev1;
            prev1= max;

        }

        return prev1;

    }}