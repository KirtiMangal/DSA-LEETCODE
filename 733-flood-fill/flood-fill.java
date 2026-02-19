class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n= image.length;
        int m= image.length;

        int originalColor= image[sr][sc];

        if(originalColor==color){
            return image;
        }

        dfs(image,sr,sc,originalColor,color);
        return image;
    }

    public static void dfs(int[][] image, int r,int c,int originalColor,int newColor){
        int n= image.length;
        int m= image[0].length;

        if(r<0 || r>=n || c<0 || c>=m){
            return;
        }

        if(originalColor!= image[r][c]){
            return;
        }

        image[r][c]= newColor;
        
        dfs(image,r+1,c,originalColor,newColor);
        dfs(image,r-1,c,originalColor,newColor);
        dfs(image,r,c+1,originalColor,newColor);
        dfs(image,r,c-1,originalColor,newColor);

    }
}