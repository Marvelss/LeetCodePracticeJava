package specialTraining.dynamicPlanning;

import java.util.Arrays;

/**
 * @Author : Vagrant
 * @Time: 2025-05-23 16:26
 * @File : DynamicPlanning8.java
 * @Description :动态规划-01背包、完全背包、至多/恰好/至少-279. 完全平方数-2（卡点：不知道物品如何遍历，答：(int i = 1; i * i <= n; i++) ）
 * 总体思路：基于完全背包，区别点：物品为i，判断条件为i * i <= n为，使用一维数组代码简洁，
 */

public class DynamicPlanning8 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            // System.out.println("前" + i + "个物品的题解:");
            for (int j = i * i; j < n + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                // System.out.print(dp[i + 1][j]);
                // System.out.print(" ");
            }
            // System.out.println("");
        }
        return dp[n];
    }
}
