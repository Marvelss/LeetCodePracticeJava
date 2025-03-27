package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-27 16:20
 * @File : Solution49.java
 * @Description : 322. 零钱兑换
 1.装满背包j需要dp[j]个物品
 2.dp[j]=min(dp[j-coin[i])+1,dp[j])
 3.dp[0]=0,非0为INT最大值，因为公式使用min
 4.先物品后背包
 */

import java.util.Arrays;

public class Solution47 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        int max = 10001;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }

                pr(dp);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    private void pr(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        System.out.println("'------------'");
    }
}
