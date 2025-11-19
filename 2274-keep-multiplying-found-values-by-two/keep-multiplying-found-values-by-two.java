class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n=nums.length;
        boolean found= true;

        while(found){
            found= false;
        

        for(int i=0;i<n;i++){
            if(original==nums[i]){
            original*=2;
            found=true;
            }
        }
        }

        return original;
        
    }
}