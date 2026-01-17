class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long max = 0;
        int n = bottomLeft.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int left   = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int right  = Math.min(topRight[i][0], topRight[j][0]);
                int bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int top    = Math.min(topRight[i][1], topRight[j][1]);

                int side = Math.min(right - left, top - bottom);
                if (side > 0)
                    max = Math.max(max, (long) side * side);
            }
        }
        return max;
    }
}
