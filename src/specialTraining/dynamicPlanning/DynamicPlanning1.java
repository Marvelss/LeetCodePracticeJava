package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-17 14:20
 * @File : DynamicPlanning1.java
 * @Description :动态规划-从记忆化搜索到递推-198. 打家劫舍-1(灵神有从递归到dp数组以及滚动数组的串讲，可以多看理解)
 */

public class DynamicPlanning1 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[1], nums[0]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
