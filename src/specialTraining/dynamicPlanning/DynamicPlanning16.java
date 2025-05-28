package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-28 20:17
 * @File : DynamicPlanning16.java
 * @Description :动态规划-状态机DP-买卖股票系列-309. 买卖股票的最佳时机含冷冻期-2
 * 基于122. 买卖股票的最佳时机 II，参考打家劫舍2，当第i天持有股票时，前一天必为冷冻期，所以只能前两天卖出
 * 同时添加第1天持有股票的情况，初始化dp[1][1] = -prices[0];
 */

public class DynamicPlanning16 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        if (prices.length == 1) return 0;
        dp[0][1] = -10 * 10 * 10 * 10;
        dp[1][1] = -prices[0];         // 第1天持有股票的情况
        for (int i = 1; i < prices.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i - 1][0] - prices[i]);
            System.out.println("第" + i + "+1天未有股票" + dp[i + 1][0]);
            System.out.println("第" + i + "+1天有股票" + dp[i + 1][1]);
        }
        return dp[prices.length][0];
    }
}
