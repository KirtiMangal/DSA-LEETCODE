class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int count=0;

        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count++;
                }

                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

                if(count==0){
                    return 0;
                }

        int time=0;
        while(!q.isEmpty()){
            int size= q.size();
            
            for(int i=0;i<size;i++){
                int[] rottenLoc= q.poll();
                int r= rottenLoc[0];
                int c= rottenLoc[1];

            int[][] neighbours= {
                {r-1,c},
                {r+1,c},
                {r,c+1},
                {r,c-1}
            };

            for(int neighbour[]: neighbours){
                int nr= neighbour[0];
                int nc= neighbour[1];

                if(nr<0 || nr>=n || nc<0 || nc>=m){
                    continue;
                }

                else if(grid[nr][nc]!=1){
                    continue;
                }

                q.add(new int[]{nr,nc});
                grid[nr][nc]=2;
                count--;

                if(count==0){
                    return time+1;
                }
            }
        }

        time++;
    }

    return -1;
}
}