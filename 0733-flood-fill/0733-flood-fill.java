class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor= image[sr][sc];
        if(startColor==color)
        return image;

        dfs(image,sr,sc,startColor,color);
        return image;
        
    }

    public void dfs(int[][] image, int r,int c, int startColor, int newColor){
        int n= image.length;
        int m= image[0].length;

        if(r<0 || r>=n || c<0 || c>=m){
            return;
        }

        if(image[r][c]!=startColor){
            return;
        }

        image[r][c]= newColor;

        dfs(image,r-1,c,startColor,newColor);
        dfs(image,r+1,c,startColor,newColor);
        dfs(image,r,c-1,startColor,newColor);
        dfs(image,r,c+1,startColor,newColor);
    }
}