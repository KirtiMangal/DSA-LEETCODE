class Pair{
    int dist;
    int row;
    int col;

    public Pair(int dist,int row,int col){
        this.dist=dist;
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int source[]= {0,0};
        int destination[]={n-1,m-1};

        if(grid[source[0]][source[1]]!=0 || grid[destination[0]][destination[1]]!=0){
            return -1;
        }

        if(destination[0]== source[0] && destination[1]==source[1]){
            return 1;
        }

        int[][] dist= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }

        Queue<Pair> q= new LinkedList<>();
        dist[source[0]][source[1]]=1;
        q.add(new Pair(1,source[0],source[1]));

        int[] dR= {-1,-1,-1,0,0,1,1,1};
        int[] dC= {-1,0,1,-1,1,-1,0,1};

        while(!q.isEmpty()){
            Pair it= q.poll();
            int dis= it.dist;
            int r= it.row;
            int c= it.col;

            for(int i=0;i<8;i++){
            int newR= r+dR[i];
            int newC= c+dC[i];

            if(newR>=0 && newR<n && newC>=0 && newC<m && grid[newR][newC]==0 && dis+1<dist[newR][newC]){
                dist[newR][newC]= dis+1;

                if(newR==destination[0] && newC==destination[1]){
                    return dis+1;
                }
                q.add(new Pair(dis+1,newR,newC));

            }
        }
    }

    return -1;
}
}