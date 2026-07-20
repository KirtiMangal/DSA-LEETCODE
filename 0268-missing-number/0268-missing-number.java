// class Solution {
//     public int missingNumber(int[] nums) {
//         int n=nums.length;

//         int total=n*(n+1)/2;

//         int sum=0;
//         for(int num:nums){
//             sum+=num;
//         }

//         return total-sum;
        
//     }
// }

// class Solution{
//     public int missingNumber(int[] nums){
//         int n=nums.length;
//         int xor=0;

//         for(int i=0;i<n;i++){
//             xor^=i;
//             xor^=nums[i];
//         }

//         xor^=n;
//         return xor;
//     }
// }

class Solution{
public int missingNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
        set.add(num);
    }

    for (int i = 0; i <= nums.length; i++) {
        if (!set.contains(i)) {
            return i;
        }
    }

    return -1;
}}
