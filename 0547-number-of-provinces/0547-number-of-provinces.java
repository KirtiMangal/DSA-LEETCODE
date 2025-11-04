class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int count=0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected, vis,i);
                count++;
            }
        }

        return count;
        
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city]= true;
        
        int m= isConnected.length;
        for(int j=0;j<m;j++){
            if(isConnected[city][j]==1 && !visited[j]){
                dfs(isConnected, visited, j);
            }
        }
    }
}