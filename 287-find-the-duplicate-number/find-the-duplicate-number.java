// class Solution {
//     public int findDuplicate(int[] nums) {
//         int n= nums.length;
//         Set<Integer> set= new HashSet<>();
//         for(int num:nums){
//             if(!set.add(num)){
//                 return num;
//             }
//         }

//         return -1;
//     }
// }


class Solution {
    public int findDuplicate(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }

        return -1;
    }}