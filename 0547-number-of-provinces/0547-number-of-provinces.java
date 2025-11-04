// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n= isConnected.length;
//         int count=0;

//         boolean[] vis= new boolean[n];

//         for(int i=0;i<n;i++){
//             if(!vis[i]){
//                 dfs(isConnected,vis,i);
//                 count++;
//             }
//         }

//         return count;
        
//     }

//     private void dfs(int[][] isConnected,boolean[] visited, int city){
//         visited[city]= true;

//         int m= isConnected.length;
//         for(int j=0;j<m;j++){
//             if(isConnected[city][j]==1 && !visited[j]){
//                 dfs(isConnected,visited,j);
//             }
//         }
//     }
// }

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean[] vis= new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(isConnected,vis,i);

                count++;
            }
        }

        return count;
    }


    private void bfs(int[][] isConnected, boolean[] visited, int start){
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        visited[start]= true;

        while(!q.isEmpty()){
            int city= q.poll();
            int m= isConnected.length;

            for(int j=0;j<m;j++){
                if(isConnected[city][j]==1 && !visited[j]){
                    visited[j]= true;

                    q.add(j);
                }
            }
        }
    }
}