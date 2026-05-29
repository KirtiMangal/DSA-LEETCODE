class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m= matrix.length;
        int n= matrix[0].length;

        ArrayList<Integer> list= new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                list.add(matrix[i][j]);
            }
        }

        Collections.sort(list);

        return list.get(k-1);
    }
}