// class Solution {
//     public void moveZeroes(int[] nums) {
//         int n= nums.length;
//         int i=0;

//         for(int j=0;j<n;j++){
//             if(nums[j]!=0){
//                 int temp= nums[i];
//                 nums[i]= nums[j];
//                 nums[j]= temp;

//                 i++;
//             }
//         }
//     }
// }

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                
                // find next non-zero
                int j = i + 1;
                while(j < n && nums[j] == 0){
                    j++;
                }

                // if found, swap
                if(j < n){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}