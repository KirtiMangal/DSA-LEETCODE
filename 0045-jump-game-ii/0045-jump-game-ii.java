class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int max=0;
        int min=0;
        int jumps=0;

        for(int i=0;i<n-1;i++){
            max= Math.max(max, i+nums[i]);

            if(i==min){
                jumps++;
                min=max;
            }
        }

        return jumps;
        
    }
}