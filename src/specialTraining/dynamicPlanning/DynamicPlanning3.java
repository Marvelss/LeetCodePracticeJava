package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-18 10:44
 * @File : DynamicPlanning3.java
 * @Description :动态规划-从记忆化搜索到递推-746. 使用最小花费爬楼梯-3
 * 卡点：可以从下标为 0 或下标为 1 的台阶开始爬楼梯
 * 卡的原因：没弄清dp[n]如何计算
 * 解决：dp[n]=上一步最小化花费+上一步花费或上上一步最小化花费+上上0一步花费，而不是+当前步的花费
 * dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);而不是dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
 */

public class DynamicPlanning3 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            // System.out.println(dp[i]);
        }
        return dp[n];
    }
}
