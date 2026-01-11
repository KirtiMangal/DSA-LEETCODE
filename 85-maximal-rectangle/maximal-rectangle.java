class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n= matrix.length;

        if (n == 0) 
        return 0;

        int cols = matrix[0].length;
        int[] height = new int[cols];
        int max = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                height[j] = row[j] == '1' ? height[j] + 1 : 0;
            }

            max = Math.max(max, largestHistogram(height));
        }
        return max;
    }

    int largestHistogram(int[] h) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int m= h.length;

        for (int i = 0; i <= m; i++) {
            int curr = (i == m) ? 0 : h[i];

            while (!st.isEmpty() && curr < h[st.peek()]) {
                int height = h[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max, height * width);
            }

            st.push(i);
        }
        return max;
    }
}
