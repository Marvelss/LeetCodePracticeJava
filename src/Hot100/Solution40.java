package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-12 19:49
 * @File : Solution40.java
 * @Description : 279. 完全平方数(不太明白，递推公式)
 1.总体思路：转为装满容量为n的背包，最少需要几样东西dp[n]
 2.dp[j]= Math.min(dp[j-i*i]+1,dp[j]);
 dp[j-i*i]+1代表装满背包还需要+1样东西
 3.初始化容量为无穷大
 4.从左到右
 */

public class Solution40 {
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=max;
        }
        dp[0]=0;
        for (int i = 1; i*i <= n; i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j]= Math.min(dp[j-i*i]+1,dp[j]);
            }
        }
        return dp[n];
    }
}
