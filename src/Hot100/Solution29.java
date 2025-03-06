package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-06 16:17
 * @File : Solution29.java
 * @Description : 198. 打家劫舍
 1.i偷的房间；dp[i]i个房间内能偷到的最大钱
 2.公式：dp[i]=max(偷，不偷），状态：偷:dp[i-2]+nums[i]；不偷:dp[i]
 3.dp[0];dp[1]
 4.正序
 */

public class Solution29 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) return nums[0];
        if (nums.length ==2) return Math.max(nums[0], nums[1]);
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
