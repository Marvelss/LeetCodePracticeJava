package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-30 14:05
 * @File : Solution48.java
 * @Description : 152. 乘积最大子数组
 1.dp[i]：以i结尾的乘积最大连续积
 2.分四种情况
 max = 正*当前数，负*当前数，当前数
 min = 正*当前数，负*当前数，当前数
 dp[i]=max和min取最大
 3.都初始化为num[i]
 4.正序遍历
 */

public class Solution48 {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        int min = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int fm = max;
            int cur = nums[i];
            max = Math.max(Math.max(max * cur, min * cur), cur);
            min = Math.min(Math.min(fm * cur, min * cur), cur);
            dp[i] = Math.max(max, min);

            System.out.println("max:" + max + "     min:" + min + "    ans" + dp[i]);

        }
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
