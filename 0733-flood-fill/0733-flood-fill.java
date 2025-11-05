class Solution {


    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        int n= image.length;
        int m= image[0].length;

        int startColor= image[sr][sc];
        if(startColor==color){
            return image;
        }

        Queue<int[]> queue= new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc]= color;

        while(!queue.isEmpty()){
            int[] cell= queue.poll();
            int r=cell[0];
            int c=cell[1];

            int neighbours[][]= 
            {
                {r-1,c},
                {r+1,c},
                {r,c-1},
                {r,c+1}
            };

            for(int neighbour[]: neighbours){
                int nr= neighbour[0];
                int nc= neighbour[1];

                if(nr<0 || nr>=n || nc<0 || nc>=m){
                    continue;
                }

                if(image[nr][nc]==startColor){
                    image[nr][nc]= color;

                    queue.offer(new int[]{nr,nc});
                }
            }
        }

        return image;
    }
    }