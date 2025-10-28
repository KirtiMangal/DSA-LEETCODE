class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int maxLen=0;
        int zerosCount=0;
        int n= nums.length;

        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zerosCount++;
            }
        

        while(zerosCount>k){
            if(nums[left]==0){
                zerosCount--;
            }

            left++;
        }

        maxLen= Math.max(maxLen, right-left+1);
        
    }
    return maxLen;
}
}