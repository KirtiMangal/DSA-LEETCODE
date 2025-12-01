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
    public int minimumEffortPath(int[][] heights) {
        int n= heights.length;
        int m= heights[0].length;

        int[][] dist= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]= (int)1e9;
            }
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.dist-b.dist);

        int src[]={0,0};
        int destination[]= {n-1,m-1};
        dist[src[0]][src[1]]=0;
        pq.add(new Pair(0,src[0],src[1]));

        int[] dR= {-1,0,1,0};
        int[] dC= {0,1,0,-1};

        while(!pq.isEmpty()){
            Pair it= pq.poll();
            int effort= it.dist;
            int r= it.row;
            int c= it.col;

            if(r==destination[0] && c==destination[1]){
                return effort;
            }

        for(int i=0;i<4;i++){
            int newR= r+dR[i];
            int newC= c+dC[i];

            if(newR>=0 && newR<n && newC>=0 && newC<m){
                int abs= Math.abs(heights[r][c]-heights[newR][newC]);
                int newEffort= Math.max(effort,abs);

                if(newEffort<dist[newR][newC]){
                    dist[newR][newC]= newEffort;

                    pq.add(new Pair(newEffort,newR,newC));
                }
            }
        }
        }

        return -1;
    }
}