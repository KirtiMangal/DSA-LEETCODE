class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        
        int n = nums.length;
        int mod = 0;
        List<Boolean> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            mod = (mod * 2 + nums[i]) % 5; 
            ans.add(mod == 0);
}

return ans;
    }

}
