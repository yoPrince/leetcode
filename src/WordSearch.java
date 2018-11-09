public class WordSearch {
    public static void main(String[] args){
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.println(new Solution().exist(board, "ADFCS"));
    }
}

class Solution {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    private int n, m;
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        int now = 0;
        boolean found = false;
        n = board.length;
        m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for( int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(now)){
                    visited[i][j] = true;
                    found = dfs(board, i, j, now + 1, word, visited);
                    if(found) return true;
                    visited[i][j] = false;
                }
            }
            if (found) return true;
        }
        return false;
    }

    boolean dfs(char[][] board, int x, int y, int now, String s, boolean[][] visited){
        if(s.length() == now){
            return true;
        }
        boolean found = false;
        for(int i = 0; i < 4; i++){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && tx < n && ty >= 0 && ty < m && visited[tx][ty] == false
                    && board[tx][ty] == s.charAt(now)){
                visited[tx][ty] = true;
                found = dfs(board, tx, ty, now + 1, s, visited);
                if(found) return true;
                visited[tx][ty] = false;
            }
        }
        return found;
    }
}