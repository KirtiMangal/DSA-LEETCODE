class Solution {
    public int maximumGap(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        int max=0;


        for(int i=1;i<n;i++){
            int curr= nums[i]-nums[i-1];

            if(curr>max){
                max= curr;
            }

        }

        return max;
    }
}