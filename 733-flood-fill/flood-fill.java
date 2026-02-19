class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n= image.length;
        int m= image[0].length;
        int original= image[sr][sc];

        if(original==color){
            return image;
        }

            dfs(image,sr,sc,original,color);

            return image;
        }

        public static void dfs(int[][] image, int r,int c, int original, int newColor){
            int n= image.length;
            int m= image[0].length;

            if(r<0 || r>=n || c<0 || c>=m){
                return;
            }

            if(original!=image[r][c]){
                return;
            }

            if(original!=image[r][c]){
                return;
            }

            image[r][c]= newColor;

            dfs(image,r,c+1,original,newColor);
            dfs(image,r,c-1,original,newColor);
            dfs(image,r+1,c,original,newColor);
            dfs(image,r-1,c,original,newColor);
    }
}