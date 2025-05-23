package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-23 16:24
 * @File : DynamicPlanning7.java
 * @Description :动态规划-01背包、完全背包、至多/恰好/至少-518. 零钱兑换 II-1
 * 同完全背包-变式：求恰好装capacity的方案数
 */

public class DynamicPlanning7 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            // System.out.println("前" + i + "个物品的题解:");

            for (int j = 0; j < amount + 1; j++) {
                if (coins[i] > j) dp[i + 1][j] = dp[i][j];
                else dp[i + 1][j] = dp[i][j] + dp[i + 1][j - coins[i]];
                // System.out.print(dp[i + 1][j]);
                // System.out.print(" ");
            }
            // System.out.println("");
        }
        return dp[n][amount];
    }
}
