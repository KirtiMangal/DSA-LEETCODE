class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }

        int n= matrix.length;
        int m= matrix[0].length;

        int[] heights= new int[m];
        int maxArea=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }

                else{
                    heights[j]=0;
                }
            }

            maxArea= Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
        
    }

    public int largestRectangleArea(int[] heights){
        int n= heights.length;
        int[] left= new int[n];
        int[] right= new int[n];

        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            left[i]= st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            right[i]= st.isEmpty()?n:st.peek();
            st.push(i);
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
            int width= right[i]-left[i]-1;
            int area= heights[i]*width;

            maxArea= Math.max(maxArea,area);
        }

        return maxArea;
    }
}