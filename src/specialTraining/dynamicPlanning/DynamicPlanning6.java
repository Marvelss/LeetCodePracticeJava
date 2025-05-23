package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-23 13:54
 * @File : DynamicPlanning6.java
 * @Description :动态规划-01背包、完全背包、至多/恰好/至少-377. 组合总和 Ⅳ-3（卡点：本题计算的是排列，需要考虑顺序）
 * 总体思路：基于完全背包，改变点：外层循环枚举体积，内层循环枚举物品，从而计算排列
 */

public class DynamicPlanning6 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            System.out.println("容量为" + j + "的题解:");
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= j) dp[j] += dp[j - nums[i]];
            }
            System.out.println("");
        }
        return dp[target];
    }
}
