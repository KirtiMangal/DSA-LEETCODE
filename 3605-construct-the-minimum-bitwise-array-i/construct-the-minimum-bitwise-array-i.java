import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            // The only even prime is 2. 
            // Any x | (x + 1) will always be odd because (x + 1) flips 
            // the rightmost 0 to 1.
            if (p == 2) {
                ans[i] = -1;
                continue;
            }

            // To minimize ans[i], we find the block of trailing 1s.
            // We need to flip the 'highest' 1 in that trailing block to 0.
            // Example: 10111 -> we want 10110 (not min) or 10011? 
            // Actually, we want to flip the last 1 that is part of the 
            // continuous block starting from the LSB.
            
            int temp = p;
            int bitToClear = 1;
            
            // Find the first 0 from the right
            // The bit immediately to the right of that 0 is the one we flip.
            while (((temp >> 1) & 1) == 1) {
                temp >>= 1;
                bitToClear <<= 1;
            }

            ans[i] = p ^ bitToClear;
        }

        return ans;
    }
}