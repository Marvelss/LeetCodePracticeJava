package graphTheory;

import java.util.*;

/**
 * @Author : Vagrant
 * @Time: 2025-06-07 20:00
 * @File : GraphTheory2.java
 * @Description :图论-99. 岛屿数量
 * 总体思路：广度优先搜索
 * 1.使用一个队列，从下标0，0开始往外扩，当遇到未标记过和值为1的陆地则结果加1
 */

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class GraphTheory2 {
    static int ans = 0;// 1节点到终点的路径
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static private void bfs(int[][] graph, boolean[][] visited, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dir[i][0];
                int nextY = current.y + dir[i][1];
                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) continue;
                if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                    queue.add(new Pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] graph = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    ans += 1;
                    bfs(graph, visited, i, j);
                }
            }
        }
        System.out.println(ans);
    }
}
