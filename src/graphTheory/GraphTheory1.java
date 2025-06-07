package graphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author : Vagrant
 * @Time: 2025-06-07 16:44
 * @File : GraphTheory1.java
 * @Description :图论-98. 所有可达路径
 * 总体思路：深度优先搜索
 */

public class GraphTheory1 {
    static List<List<Integer>> result = new ArrayList<>(); // 收集符合条件的路径
    static List<Integer> path = new ArrayList<>(); // 1节点到终点的路径

    private static void dfs(int[][] graph, int x, int n) {
//        终止条件
        if (x == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (graph[x][i] == 1) {
                path.add(x);
                dfs(graph, i, n);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 节点编号从1到n，所以申请 n+1 这么大的数组
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            // 使用邻接矩阵表示无向图，1 表示 s 与 t 是相连的
            graph[s][t] = 1;
        }
        path.add(1);
        dfs(graph, 1, n);


        // 输出结果
        if (result.isEmpty()) System.out.println(-1);
        for (List<Integer> pa : result) {
            for (int i = 0; i < pa.size() - 1; i++) {
                System.out.print(pa.get(i) + " ");
            }
            System.out.println(pa.get(pa.size() - 1));
        }
    }


    //    图创建
//    1.邻接表
    private generateGraph1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            // 使用邻接矩阵表示无向图，1 表示 s 与 t 是相连的
            graph.get(s).add(t);
        }
    }


    //    2.邻接矩阵
    private generateGraph2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 节点编号从1到n，所以申请 n+1 这么大的数组
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            // 使用邻接矩阵表示无向图，1 表示 s 与 t 是相连的
            graph[s][t] = 1;
        }
    }
}
