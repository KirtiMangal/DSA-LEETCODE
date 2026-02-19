class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean[] vis= new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i);
                count++;
            }
        }

        return count;
    }

    public static void dfs(int[][] isConnected, boolean[] vis, int city){
        int m= isConnected.length;
        vis[city]= true;

        for(int j=0;j<m;j++){
            if(isConnected[city][j]==1 && !vis[j]){
                dfs(isConnected,vis,j);
            }
        }
    }
}