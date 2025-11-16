class Solution {
    public int numSub(String s) {
        long ans = 0;
        long count = 0;
        int mod = 1000000007;

        for (char c : s.toCharArray()) {

            if (c == '1') {
                count++;           
                ans = (ans + count) % mod; 
            } 
            
            else {
                count= 0;        
            }
        }

        return (int) ans;
    }
}
