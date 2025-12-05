class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        char[] ch = word.toCharArray();   // moved here (cannot declare inside loops)

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(board[i][j] == ch[0]){  // compare first character
                    if(dfs(board, i, j, m, n, ch, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int m, int n, char[] ch, int idx){

        // boundary + mismatch
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != ch[idx]){
            return false;
        }

        // found full word
        if(idx == ch.length - 1){
            return true;
        }

        // mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        // SAME STYLE — 4 DFS CALLS manually written
        boolean found =
            dfs(board, i+1, j, m, n, ch, idx+1) ||
            dfs(board, i-1, j, m, n, ch, idx+1) ||
            dfs(board, i, j+1, m, n, ch, idx+1) ||
            dfs(board, i, j-1, m, n, ch, idx+1);

        board[i][j] = temp;
        return found;
    }
}
