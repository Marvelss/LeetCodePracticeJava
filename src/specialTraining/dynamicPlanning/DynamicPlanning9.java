package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-25 14:15
 * @File : DynamicPlanning9.java
 * @Description :动态规划-01背包、完全背包、至多/恰好/至少-416. 分割等和子集-2
 * 卡点：定义没搞清
 * 能否从 nums 中选出一个子序列，其元素和恰好等于s/2--->dp[i][j],前i个物品中，选出一个和恰好==j
 */

public class DynamicPlanning9 {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        if (s % 2 == 1) {
            return false;
        }
        int p = s / 2; // 背包容量
        boolean[][] dp = new boolean[nums.length + 1][p + 1];
        dp[0][0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < p + 1; j++) {
                if (nums[i] > j) dp[i+1][j] = dp[i][j];
                else dp[i+1][j] = dp[i][j] || dp[i][j - nums[i]];
            }
        }
        return dp[nums.length][p];
    }
}
