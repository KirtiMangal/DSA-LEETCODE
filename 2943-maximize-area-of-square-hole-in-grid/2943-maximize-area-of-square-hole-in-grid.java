class Solution {

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxConsecutive(hBars);
        int maxV = maxConsecutive(vBars);

        int side = Math.min(maxH, maxV);
        return side * side;
    }

    private int maxConsecutive(int[] bars) {
        int n= bars.length;

        if (n == 0) 
        return 1;

        Arrays.sort(bars);

        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i<n; i++) {

            if (bars[i] == bars[i - 1] + 1) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } 
            
            else {
                currLen = 1;
            }
        }

        return maxLen + 1;
    }
}
