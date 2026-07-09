// class Solution {
//     public int majorityElement(int[] nums) {

//         int n = nums.length;

//         for(int i = 0; i < n; i++){

//             int count = 0;

//             for(int j = 0; j < n; j++){

//                 if(nums[i] == nums[j]){
//                     count++;
//                 }
//             }

//             if(count > n/2){
//                 return nums[i];
//             }
//         }

//         return -1;
//     }
// }

// class Solution {
//     public int majorityElement(int[] nums) {
//         int n=nums.length;

//         HashMap<Integer,Integer> map= new HashMap<>();
//         int count=0;

//         for(int i=0;i<n;i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);

//             if(map.get(nums[i])>n/2){
//                 return nums[i];
//             }
//         }

//         return
//     }}

class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);

        return nums[n/2];
    }}