// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         int n= nums.length;
//         Arrays.sort(nums);

//         for(int i=0;i<n-1;i++){
//             if(nums[i]==nums[i+1]){
//                 return true;
//             }
//         }

//         return false;
//     }
// }

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n= nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();

        for(int num:nums){
            if(map.containsKey(num)){
                return true;
            }

            map.put(num,1);
        }

        return false;
    }}