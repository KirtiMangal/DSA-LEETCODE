class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int largest=0;
        int sec_largest=0;

        for(int num:nums){
            if(num>largest){
                sec_largest= largest;
                largest=num;

            }

            else{
                sec_largest= Math.max(sec_largest,num);
            }
        }

        return (largest-1) * (sec_largest-1);
    }
}