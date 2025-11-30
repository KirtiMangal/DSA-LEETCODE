class Solution {
    public int minSubarray(int[] nums, int p) {
        long total=0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }

        long rem= total%p;
        if(rem==0){
            return 0;
        }

        Map<Long,Integer> map= new HashMap<>();
        map.put(0L,-1);

        long prefix=0;
        int ans= n;

        for(int i=0;i<n;i++){
            prefix= (prefix+nums[i]) % p;

            long target= (prefix-rem+p) % p;
            if(map.containsKey(target)){
                ans= Math.min(ans,i-map.get(target));
            }
            map.put(prefix,i);
        }

        return ans==n?-1:ans;
        
    }
}