package specialTraining.dynamicPlanning;

import java.util.Arrays;

/**
 * @Author : Vagrant
 * @Time: 2025-05-26 16:39
 * @File : DynamicPlanning10.java
 * @Description :动态规划-01背包、完全背包、至多/恰好/至少-213. 打家劫舍 II-2
 * 卡点：不能通过nums[0] >= nums[1]判断是否偷第一个和第二个（贪心思想），应该分解成两个子问题考虑
 */

public class DynamicPlanning10 {
    public int robTemp(int[] nums) {
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

    public int rob(int[] nums) {
        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            nums1[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            nums2[i - 1] = nums[i];
        }
        return Math.max(robTemp(nums1), robTemp(nums2));
    }
}
