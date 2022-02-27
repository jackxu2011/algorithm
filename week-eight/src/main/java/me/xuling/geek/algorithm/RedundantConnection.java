package me.xuling.geek.algorithm;

/**
 * @author jack
 * @since 2022/2/27
 **/
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges.length == 0) {
            return new int[0];
        }
        int n = 0;
        for (int i = 0; i < edges.length; i++) {
            n = Math.max(n, Math.max(edges[i][0], edges[i][1]));
        }
        // makeSet
        int[] fa = new int[n+1];
        for (int i = 0; i <= n; i++) {
            fa[i] = i;
        }
        for  (int i = 0; i < edges.length; i++) {
            if(find(fa, edges[i][0]) == find(fa, edges[i][1])) {
                return edges[i];
            }
            fa[find(fa, edges[i][0])] = find(fa, edges[i][1]);
        }
        return new int[0];
    }

    private int find(int[] fa, int x) {
        if(fa[x] == x) {
            return x;
        }
        return fa[x] = find(fa, fa[x]);
    }
}
