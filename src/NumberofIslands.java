public class NumberofIslands {
    public static void main(String[] args){
        char[][] grid = {   {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}};
        System.out.println(new Solution().numIslands(grid));
    }
}

class Solution {
    private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};
    private int n, m;

    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        n = grid.length;
        m = grid[0].length;
        int cnt = 0;
        for( int i = 0; i < n; i++){
            for( int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        for( int i = 0; i < 4; i++){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && tx < n && ty >= 0 && ty < m && grid[tx][ty] == '1') dfs(grid, tx, ty);
        }
    }
}