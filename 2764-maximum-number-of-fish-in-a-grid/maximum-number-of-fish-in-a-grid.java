class Solution {
    public int findMaxFish(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int max=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0){
                    int fish= dfs(grid,i,j);
                    max= Math.max(max,fish);
                }
            }
        }
        return max;
    }

    public static int dfs(int[][] grid,int i,int j){
        int n= grid.length;
        int m= grid[0].length;

        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0){
            return 0;
        }

        int fish= grid[i][j];
        grid[i][j]=0;

        fish+= dfs(grid,i+1,j);
        fish+= dfs(grid,i-1,j);
        fish+= dfs(grid,i,j+1);
        fish+= dfs(grid,i,j-1);

        return fish;
    }
}