// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n= matrix.length;
//         int m= matrix[0].length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(matrix[i][j]==target)
//                 return true;
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        int m= matrix[0].length;

        int low=0;
        int high= n*m-1;

        while(low<=high){
            int mid= low+(high-low)/2;

            int midVal= matrix[mid/m][mid%m];

            if(midVal==target){
                return true;
            }

            if(midVal<target){
                low= mid+1;
            }

            else{
                high= mid-1;
            }
        }

        return false;
    }
}