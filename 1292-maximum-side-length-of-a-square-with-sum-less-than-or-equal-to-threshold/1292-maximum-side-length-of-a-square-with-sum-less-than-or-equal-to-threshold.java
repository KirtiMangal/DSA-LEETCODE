class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // Step 1: Prefix sum matrix
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }

        // Step 2: Binary search on side length
        int low = 0, high = Math.min(m, n);
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (existsSquare(prefix, m, n, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean existsSquare(int[][] prefix, int m, int n, int len, int threshold) {
        for (int i = 0; i + len <= m; i++) {
            for (int j = 0; j + len <= n; j++) {
                int sum = prefix[i + len][j + len]
                        - prefix[i][j + len]
                        - prefix[i + len][j]
                        + prefix[i][j];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
