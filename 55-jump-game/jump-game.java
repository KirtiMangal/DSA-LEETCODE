// class Solution {
//     public boolean canJump(int[] nums) {
//         int n= nums.length;
//         int finaltime=n-1;

//         for(int i=n-2;i>=0;i--){
//             if(i+nums[i]>=finaltime){
//                 finaltime=i;
//             }
//         }

//         return finaltime==0;
//     }
// }

class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            if(i>max){
                return false;
            }

            max= Math.max(max, i+nums[i]);
        }

        return true;
    }}