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
        while(!q.isEmpty() && count>0){
            int size= q.size();

            int[][] directions= 
            {
                {0,1},
                {1,0},
                {-1,0},
                {0,-1}

            };

            for(int i=0;i<size;i++){
                int[] curr= q.poll();
                int r= curr[0];
                int c= curr[1];

                for(int dir[]: directions){
                    int nr= r+dir[0];
                    int nc= c+dir[1];

                    if(nr<n && nr>=0 && nc<m && nc>=0 && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                        count--;
                    }
                }
            }

            time++;
        }

        return count==0 ? time:-1;
    }
}