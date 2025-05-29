package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-29 8:26
 * @File : DynamicPlanning17.java
 * @Description :动态规划-状态机DP-买卖股票系列-714. 买卖股票的最佳时机含手续费-1
 * 基于122. 买卖股票的最佳时机 II，区别：在卖出股票时，减去额外小费
 */

public class DynamicPlanning17 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];
        if (prices.length == 1) return 0;
        dp[0][1] = -10 * 10 * 10 * 10 * 10 * 10;
        // dp[1][1] = -prices[0];         // 第1天持有股票的情况
        for (int i = 0; i < prices.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i] - fee);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
            // System.out.println("第" + i + "+1天未有股票" + dp[i + 1][0]);
            // System.out.println("第" + i + "+1天有股票" + dp[i + 1][1]);
        }
        return dp[prices.length][0];
    }
}
