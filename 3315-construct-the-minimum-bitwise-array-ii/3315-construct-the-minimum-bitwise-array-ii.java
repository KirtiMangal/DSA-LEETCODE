import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            if (p == 2) {
                ans[i] = -1;
                continue;
            }

            int temp = p;
            int bitToClear = 0;
            
                for (int j = 0; j <= 30; j++) {
                if (((p >> j) & 1) == 0) {
                    bitToClear = 1 << (j - 1);
                    break;
                }
            }

            ans[i] = p ^ bitToClear;
        }

        return ans;
    }
}