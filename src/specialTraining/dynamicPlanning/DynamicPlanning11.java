package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-27 9:35
 * @File : DynamicPlanning11.java
 * @Description :动态规划-01背包、完全背包、至多/恰好/至少-64. 最小路径和-1（花了很多时间，但一步一步想之后调试出）
 * 定义：第i行，第j列前的最小路径和
 */

public class DynamicPlanning11 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int sumT1 = 0;
        for (int i = 0; i < row; i++) {
            sumT1 += grid[i][0];
            dp[i][0] = sumT1;
        }
        sumT1 = 0;
        for (int j = 0; j < col; j++) {
            sumT1 += grid[0][j];
            dp[0][j] = sumT1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                System.out.println("第" + i + "-1行，" + "第" + j + "列:" + dp[i - 1][j]);
                System.out.println("第" + i + "行，" + "第" + j + "-1列:" + dp[i][j - 1]);
                System.out.println("第" + i + "行，" + "第" + j + "列:" + dp[i][j]);
            }
        }
        return dp[row - 1][col - 1];
    }
}
