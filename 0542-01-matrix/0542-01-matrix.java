class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;

        int[][] dist= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                }

                else{
                    dist[i][j]= Integer.MAX_VALUE;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    dfs(mat,dist,i,j);
                }
            }
        }

        return dist;   
    }

    public void dfs(int[][] mat, int[][] dist,int x,int y){
        int[][] dirs= {
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        for(int[] d: dirs){
            int nx= x+d[0];
            int ny= y+d[1];

            if(nx>=0 && nx<mat.length && ny>=0 && ny<mat[0].length){
                if(dist[nx][ny]>dist[x][y]+1){
                    dist[nx][ny]= dist[x][y]+1;
                    dfs(mat,dist,nx,ny);
                }
            }
        }
    }
}