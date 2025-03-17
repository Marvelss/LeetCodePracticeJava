package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-17 18:53
 * @File : Solution41.java
 * @Description : 309. 买卖股票的最佳时机含冷冻期(思路、代码抄)
 1.dp[i][0]:持股状态；dp[i][1]:保持卖出股票；dp[i][2]：卖出股票；dp[i][3]：冷冻期
 2.1dp[i][0]=max(dp[i-1][0],dp[i-1][3]-price[i],dp[i-1][1]-price[i])
 2.2dp[i][1]=max(dp[i-1][1],dp[i-1][3])
 2.3dp[i][2]=dp[i-1][0]+price[i]
 2.4dp[i][3]=dp[i-1][2]
 */

public class Solution41 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int dp[][] = new int[2][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i % 2][0] = Math.max(Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] - prices[i]), dp[(i - 1) % 2][3] - prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1)%2][3]);
            dp[i % 2][2] = dp[(i - 1) % 2][0] + prices[i];
            dp[i % 2][3] = dp[(i - 1) % 2][2];
        }
        return Math.max(Math.max(dp[(len - 1) % 2][1], dp[(len - 1) % 2][2]), dp[(len - 1) % 2][3]);
    }
}
