package specialTraining.dynamicPlanning;

import java.util.Arrays;

/**
 * @Author : Vagrant
 * @Time: 2025-05-18 18:18
 * @File : DynamicPlanning4.java
 * @Description :动态规划-01背包、完全背包、至多/恰好/至少-494. 目标和-2
 */

public class DynamicPlanning4 {
    //    递归
    private int dfs(int x, int t, int[] nums, int n) {
        if (x < 0) return t == 0 ? 1 : 0;
        if (nums[x] > t) return dfs(x - 1, t, nums, n);
        return dfs(x - 1, t, nums, n) + dfs(x - 1, t - nums[x], nums, n);
    }

    //    记忆化搜索
    private int dfs(int x, int t, int[] nums, int n, int[][] memo) {
        if (x < 0) return t == 0 ? 1 : 0;
        if (memo[x][t] != -1) return memo[x][t];
        int temp;
        if (nums[x] > t) temp = dfs(x - 1, t, nums, n, memo);
        else temp = dfs(x - 1, t, nums, n, memo) + dfs(x - 1, t - nums[x], nums, n, memo);
        memo[x][t] = temp;
        return memo[x][t];
    }


    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        s -= Math.abs(target);
        if (s < 0 || s % 2 == 1) {
            return 0;
        }
        int p = s / 2; // 背包容量

//      =================================方法1：（递归：由传统递归-->记忆化搜索）=================================
        int n = nums.length;
        int[][] memo = new int[nums.length][p + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        dfs(n - 1, p, nums, n, memo);

//      =================================方法2：递推=================================

//        int[][] dp = new int[nums.length + 1][p + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 1; j < p + 1; j++) {
//                if (nums[i] > j) dp[i][j] = dp[i - 1][j];
//                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
//            }
//        }

//      =================================方法3.1（空间优化）：滚动数组（两个数组）=================================
//        时间复杂度由O（N*Target）-->由O（Target）
//        int[][] dp = new int[2][p + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i <= nums.length; i++) {
//            for (int j = 0; j <= p; j++) {
//                // 不选当前数字 nums[i-1]
//                dp[i % 2][j] = dp[(i - 1) % 2][j];
//                // 选当前数字 nums[i-1]，前提是 j >= nums[i-1]
//                if (j >= nums[i - 1]) {
//                    dp[i % 2][j] += dp[(i - 1) % 2][j - nums[i - 1]];
//                }
//            }
//        }
//      =================================方法3.2（空间优化）：（一个数组）=================================
//        卡点：for (int j = p; j >= nums[i]; j--) ，中边界条件应为j >= nums[i]，因为当剩余背包容量>=物品容量
        int[] dp = new int[p + 1];
        dp[0] = 1;
        System.out.println(p);
        for (int i = 0; i < nums.length; i++) {
            for (int j = p; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
                System.out.println(dp[j]);
            }
        }
        return dp[p];
    }
}
