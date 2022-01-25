package me.xuling.geek.algorithm;

/**
 * @author jack
 * @since 2022/1/25
 **/
public class SurroundedRegions {
    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i< m; i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0);
            }
            if(board[i][n-1] == 'O') {
                dfs(i, n-1);
            }
        }
        for(int j = 0; j< n; j++) {
            if(board[0][j] == 'O') {
                dfs(0, j);
            }
            if(board[m-1][j] == 'O') {
                dfs(m-1, j);
            }
        }
        for(int i = 0; i< m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'X') continue;
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int x, int y) {
        if(board[x][y] == 'X' || board[x][y] == 'Z') {
            return;
        }
        board[x][y] = 'Z';
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(validIndex(nx, ny)) {
                dfs(nx, ny);
            }
        }

    }
    private boolean validIndex(int x, int y) {
        return x>=0 && x< m && y>=0 && y < n;
    }

    private char[][] board;
    private int m;
    private int n;
    private int[] dx = new int[]{1, 0, 0 , -1};
    private int[] dy = new int[]{0, 1, -1, 0};
}
