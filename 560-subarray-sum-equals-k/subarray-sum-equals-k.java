class Solution {
    public int subarraySum(int[] nums, int k) {
        int n= nums.length;
        int ans=0;

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                // If initializing here, then counting sum as 0 again and again in inner loop int sum=0;
                sum+= nums[j];

                if(sum==k){
                    ans++;
                }
            }

        }
        
        return ans;
    }
}