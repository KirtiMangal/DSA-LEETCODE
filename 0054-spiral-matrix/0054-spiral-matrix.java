class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;

       int srow=0;
       int erow= n-1;
       int scol=0;
       int ecol= m-1;

       List<Integer> result= new ArrayList<>();

       while(srow<=erow && scol<=ecol){

        for(int j=scol;j<=ecol;j++){
            result.add(matrix[srow][j]);
        }

        srow++;

        for(int i=srow;i<=erow;i++){
            result.add(matrix[i][ecol]);
        }

        ecol--;

        if(srow<=erow){
        for(int j=ecol;j>=scol;j--){
            result.add(matrix[erow][j]);
        }

        erow--;
        }

        if(scol<=ecol){
        for(int i=erow;i>=srow;i--){
            result.add(matrix[i][scol]);
        }
        
        scol++;
       }
    }

    return result;
}
}