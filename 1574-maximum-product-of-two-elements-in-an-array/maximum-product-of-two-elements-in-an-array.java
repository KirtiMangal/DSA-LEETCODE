// class Solution {
//     public int maxProduct(int[] nums) {
//         int n= nums.length;
//         int largest=0;
//         int sec_largest=0;

//         for(int num:nums){
//             if(num>largest){
//                 sec_largest= largest;
//                 largest=num;

//             }

//             else{
//                 sec_largest= Math.max(sec_largest,num);
//             }
//         }

//         return (largest-1) * (sec_largest-1);
//     }
// }

class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int result=0;
        int curr_max= nums[0];

        for(int i=1;i<n;i++){
            result= Math.max(result, (nums[i]-1) * (curr_max-1));

            curr_max= Math.max(curr_max, nums[i]);
        }

        return result;
    }}