package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-18 19:33
 * @File : Solution42.java
 * @Description : 312. 戳气球
 1.i：左边界；j：右边界；dp[i][j]：在i,j区间内的最大金币
 2.dp[i][j]=max(dp[i][j],dp[i][k]+dp[i]*dp[k]*dp[i+len-1]+dp[k][i+len-1])
 3. dp[0] = 1; dp[n + 1] = 1;
 4.从左到右

 */

public class Solution42 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        temp[0] = 1;
        temp[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            temp[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i <= n + 2 - len; i++) {
                for (int k = i + 1; k < i + len - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    dp[i][i + len - 1] = Math.max(dp[i][i + len - 1], left + temp[i] * temp[k] * temp[i + len - 1] + right);

                }
            }
        }

        return dp[0][n + 1];
    }
}
