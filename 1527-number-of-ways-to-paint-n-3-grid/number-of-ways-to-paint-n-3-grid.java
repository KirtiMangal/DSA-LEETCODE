class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        long type2 = 6; 
        long type3 = 6; 

        for (int i = 2; i <= n; i++) {
            long newType2 = (type2 * 3 + type3 * 2) % MOD;
            long newType3 = (type2 * 2 + type3 * 2) % MOD;

            type2 = newType2;
            type3 = newType3;
        }

        return (int)((type2 + type3) % MOD);
    }
}
