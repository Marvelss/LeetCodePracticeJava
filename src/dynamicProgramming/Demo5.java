package dynamicProgramming;/*
 * @Author : Vagrant
 * @Time: 2025-03-25 20:15
 * @File : Demo5.java
 * @Description : 213. 打家劫舍 II
 总体思路：将环形问题转为线性问题，分三种情况
 1.不包含首尾元素
 2.包含首元素
 3.包含尾元素
 情况2和3包含情况1，故去可去除，因为dp[i]代表，考虑i个元素内偷
 */

public class Demo5 {
    private int robTemp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        if (nums.length==1)return nums[0];
        if (nums.length==2)return Math.max(nums[0],nums[1]);
        int[] numsLeft = new int[nums.length];
        int[] numsRight = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            numsLeft[i]=nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            numsRight[i]=nums[i];
        }
        return Math.max(robTemp(numsLeft),robTemp(numsRight));
    }
}
