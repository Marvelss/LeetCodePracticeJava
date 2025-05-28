package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-28 19:13
 * @File : DynamicPlanning14.java
 * @Description :动态规划-最长递增子序列 LIS-300. 最长递增子序列-2
 * 背，
 * dp定义：以i结尾的前最长子序列长度
 */

public class DynamicPlanning14 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i > j && nums[i] > nums[j]) dp[i] = Math.max(dp[j], dp[i]);
            }
            dp[i]++;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
