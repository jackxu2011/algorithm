package me.xuling.geek.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author jack
 * @since 2022/2/26
 **/
public class Dijkstra {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 3; j++) {
                    edges[i][j] = scanner.nextInt();
                }
            }
            System.out.println(dijkstra.shortest(n, edges));
        }
    }

    int shortest(int n, int[][] edges) {
        ver = new ArrayList<>(n + 1);
        edge = new ArrayList<>(n + 1);
        visited = new boolean[n+1];
        dist = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ver.add(new ArrayList<>());
            edge.add(new ArrayList<>());
            dist[i] = 1 << 30;
        }
        dist[1] = 0;
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int z = edges[i][2];
            ver.get(x).add(y);
            edge.get(x).add(z);
        }
        queue.offer(new Pair(0, 1));
        while (!queue.isEmpty()){
            int x = queue.poll().number;
            if(visited[x]) {
                continue;
            }
            visited[x] = true;
            for(int i = 0; i < ver.get(x).size(); i++) {
                int y = ver.get(x).get(i);
                int z = edge.get(x).get(i);
                if(dist[y] > dist[x] + z) {
                    dist[y] = dist[x] + z;
                    queue.offer(new Pair(dist[y], y));
                }
            }
        }
        if (dist[n] == 1 << 30) {
            return -1;
        }
        return dist[n];
    }

    static class Pair {
        public int distance;
        public int number;
        public Pair(int distance, int number) {
            this.distance = distance;
            this.number = number;
        }
    }

    private List<List<Integer>> ver;
    private List<List<Integer>> edge;
    private int[] dist;
    private boolean[] visited;
    private PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> o2.distance - o1.distance);

}
