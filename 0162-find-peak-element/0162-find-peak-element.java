// class Solution {
//     public int findPeakElement(int[] nums) {
//         int n= nums.length;
//         int max=nums[0];
//         int index=0;

//         for(int i=0;i<n;i++){
//             if(nums[i]>max){
//                 max=nums[i];
//                 index=i;

//             }
//         }
//         return ;
//     }
// }

class Solution {
    public int findPeakElement(int[] nums) {
        int n= nums.length;
        int low=0;
        int high= nums.length-1;

        while(low<high){
            int mid= low+(high-low)/2;

            if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }

            else{
                high=mid;
            }
        }

        return low;
    }}