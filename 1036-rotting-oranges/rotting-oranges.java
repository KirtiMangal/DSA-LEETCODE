class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int fresh=0;

        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }

                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(fresh==0){
            return 0;
        }

        int time=0;
        while(!q.isEmpty() && fresh>0){
            int size= q.size();
            for(int i=0;i<size;i++){
                int[] curr= q.poll();
                int r= curr[0];
                int c= curr[1];

            int[][] dir= {{0,1},{1,0},{-1,0},{0,-1}};
            for(int[] directions:dir){
                int newR= directions[0]+r;
                int newC= directions[1]+c;

                while(newR>=0 && newR<n && newC>=0 && newC<m && grid[newR][newC]==1){
                    grid[newR][newC]=2;
                    q.add(new int[]{newR,newC});
                    fresh--;
                }
            }
        }

        time++;
    }

    return fresh==0 ? time:-1;
}
}