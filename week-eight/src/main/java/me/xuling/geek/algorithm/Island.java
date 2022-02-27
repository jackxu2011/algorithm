package me.xuling.geek.algorithm;

/**
 * @author jack
 * @since 2022/2/27
 **/
public class Island {
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        //makeSet
        fa = new int[m*n];
        for (int i = 0; i < m*n; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '0') {
                    fa[num(i,j)] = -1;
                    continue;
                }
                for (int k = 0; k < 2; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if(valid(ni, nj) && grid[ni][nj] == '1') {
                        union(num(i,j), num(ni, nj));
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m*n; i++) {
            if(fa[i] == i) {
                ans++;
            }
        }

        return ans;
    }

    private boolean valid(int i, int j) {
        return i < m && j < n;
    }

    private int num(int i, int j) {
        return i * n + j;
    }

    private int find(int x) {
        if(fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    private void union(int x, int y) {
        if (find(x) == find(y)) return;
        fa[find(x)] = find(y);
    }

    private int m;
    private int n;
    private int[] dx = new int[]{ 1, 0 };
    private int[] dy = new int[]{ 0, 1 };
    private int[] fa;
    private char[][] grid;
}
