// class Solution {
//     public int missingNumber(int[] nums) {
//         int n= nums.length;

//         Set<Integer> set= new HashSet<>();
//         for(int num:nums){
//             set.add(num);
//         }

//         for(int i=0;i<=n;i++){
//             if(!set.contains(i)){
//                 return i;
//             }
//         }

//         return -1;
//     }
// }

class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                return i;
            }
        }

        return n;
    }}