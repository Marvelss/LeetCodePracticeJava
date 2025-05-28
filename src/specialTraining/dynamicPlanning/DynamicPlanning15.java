package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-28 19:50
 * @File : DynamicPlanning15.java
 * @Description :动态规划-状态机DP-买卖股票系列-122. 买卖股票的最佳时机 II-2
 * dp[i]：第i天时，持有/未持有的最大利润
 * 子问题：第i-1天时，持有/未持有的最大利润
 * 状态：若第i天持有，第i-1（前一天也持有，）与第i-1（未持有，买入）-价格
 * 状态：若第i天未持有，第i-1（前一天也未持有）与第i-1（持有，卖出）+价格
 */

public class DynamicPlanning15 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][1] = -10 * 10 * 10 * 10;
        for (int i = 0; i < prices.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[prices.length][0];
    }
}
