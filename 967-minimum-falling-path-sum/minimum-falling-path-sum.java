class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;

        int[][] dp= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    dp[i][j]= matrix[i][j];
                }

                else{
                    int left= (j>0)?dp[i-1][j-1] : Integer.MAX_VALUE;
                    int right= (j<m-1)?dp[i-1][j+1] : Integer.MAX_VALUE;

                    dp[i][j]= matrix[i][j] + Math.min(dp[i-1][j], Math.min(left,right));
                }
            }
        }

        int ans= Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            ans= Math.min(ans, dp[n-1][i]);
        }

        return ans;
    }
}