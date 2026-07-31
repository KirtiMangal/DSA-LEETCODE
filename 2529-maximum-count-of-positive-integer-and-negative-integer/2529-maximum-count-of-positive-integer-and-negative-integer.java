// class Solution {
//     public int maximumCount(int[] nums) {
//         int n= nums.length;
//         int positive=0;
//         int negative=0;

//         for(int i=0;i<n;i++){
//             if(nums[i]>0){
//                 positive++;
//             }

//             else if(nums[i]<0){
//                 negative++;
//             }
//         }

//         return Math.max(positive,negative);
//     }
// }

class Solution {
    public int maximumCount(int[] nums) {
        int n= nums.length;
        int low=0;
        int high= n-1;

        while(low<=high){
            int mid= low+(high-low)/2;

            if(nums[mid]>=0){
                high= mid-1;
            }

            else{
                low= mid+1;
            }
        }

        int negativeCount= low;

         low=0;
         high= n-1;

        while(low<=high){
            int mid= low+(high-low)/2;

            if(nums[mid]>0){
                high= mid-1;
            }

            else{
                low=mid+1;
            }
        }

        int positiveCount= n-low;
        return Math.max(negativeCount,positiveCount);
    }}