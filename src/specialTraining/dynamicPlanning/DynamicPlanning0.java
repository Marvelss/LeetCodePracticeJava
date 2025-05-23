package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-19 9:52
 * @File : DynamicPlanning0.java
 * @Description :动态规划-从记忆化搜索到递推-0-1背包问题（从DFS-->记忆化搜索-->递推-->滚动数组-->一维数组）
 */

import java.util.*;

public class DynamicPlanning0 {
    private static int dfs(int x, int spV, int n, int[] values, int[] weights, int[][] memo) {
        if (memo[x][spV] != 0) return memo[x][spV];
        int sum = 0;
        if (x > n) return 0;
        else {
            if (spV < weights[x]) sum = dfs(x + 1, spV, n, values, weights, memo);
            else
                sum = Math.max(dfs(x + 1, spV, n, values, weights, memo),
                        dfs(x + 1, spV - weights[x], n, values, weights, memo) + values[x]);
        }
        memo[x][spV] = sum;
        return sum;
    }

    public static void main(String[] args) {
        // 背包容量 N
        // 物品种类 M
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] values = new int[M];
        int[] weights = new int[M];
        int[][] memo = new int[M][M];

        for (int i = 0; i < M; i++) {
            weights[i] = sc.nextInt();
        }


        for (int i = 0; i < M; i++) {
            values[i] = sc.nextInt();
        }

        int res = dfs(1, N, M, values, weights, memo);
        System.out.println(res);
    }
}
