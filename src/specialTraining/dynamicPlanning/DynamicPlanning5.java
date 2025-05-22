package specialTraining.dynamicPlanning;

import java.util.Arrays;

/**
 * @Author : Vagrant
 * @Time: 2025-05-22 18:35
 * @File : DynamicPlanning5.java
 * @Description :动态规划-01背包、完全背包、至多/恰好/至少-322. 零钱兑换-3
 */

public class DynamicPlanning5 {
    private int dfs(int i, int target, int[] coins, int[][] memo) {
//        System.out.println("i:" + i + "target:" + target);
        if (i < 0) return target == 0 ? 0 : Integer.MAX_VALUE - 1;
        if (memo[i][target] != -1) return memo[i][target];
        int temp;
        if (coins[i] > target) temp = dfs(i - 1, target, coins, memo);
        else temp = Math.min(dfs(i - 1, target, coins, memo), dfs(i, target - coins[i], coins, memo) + 1);
        memo[i][target] = temp;
        return memo[i][target];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] memo = new int[n + 1][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
//      =================================方法1：递归+记忆化搜索=================================
//        int res = dfs(n - 1, amount, coins, memo);
//        return res == Integer.MAX_VALUE - 1 ? -1 : res;

//      =================================方法2：递推=================================
//        卡点：初始化
//        1.1dp[0][0]=0；前0个物品凑成总金额0个最小硬币个数为0
//        1.2其他值初始化为无穷大
//        int[][] dp = new int[n + 1][amount + 1];
//        for (int i = 0; i < dp.length; i++) {
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
//        dp[0][0] = 0;
//        for (int i = 0; i < n; i++) {
//            System.out.println("前" + i + "个物品的题解:");
//            for (int j = 0; j <= amount; j++) {
//                if (coins[i] > j) dp[i + 1][j] = dp[i][j];
//                else dp[i + 1][j] = Math.min(dp[i][j], dp[i + 1][j - coins[i]] + 1);
//                System.out.print(dp[i + 1][j]);
//                System.out.print(" ");
//            }
//            System.out.println("");
//        }
//      =================================方法3：滚动数组=================================
//        int[][] dp = new int[2][amount + 1];
//        for (int i = 0; i < dp.length; i++) {
//            Arrays.fill(dp[i], Integer.MAX_VALUE-1);
//        }
//        dp[0][0] = 0;
//        for (int i = 0; i < n; i++) {
//            System.out.println("前" + i + "个物品的题解:");
//            for (int j = 0; j <= amount; j++) {
//                if (coins[i] > j) dp[(i + 1) % 2][j] = dp[i % 2][j];
//                else dp[(i + 1) % 2][j] = Math.min(dp[i % 2][j], dp[(i + 1) % 2][j - coins[i]] + 1);
//                System.out.print(dp[(i + 1) % 2][j]);
//                System.out.print(" ");
//            }
//            System.out.println("");
//        }

//      =================================方法3.2：一维数组=================================
//        卡点：dp[j]需要正序for (int j = coins[i]; j <= amount; j--)，
//        而不是for (int j = amount; j >= coins[i]; j--)，因为会覆盖答案
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("前" + i + "个物品的题解:");
            for (int j = coins[i]; j <= amount; j++) {

                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                System.out.print(dp[j]);

                System.out.print(" ");
            }
            System.out.println("");
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];

    }
}
