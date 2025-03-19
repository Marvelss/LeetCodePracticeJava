package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-19 8:34
 * @File : Solution4.java
 * @Description : LCR 126. 斐波那契数
 总体思路：
 1.n,dp[n]：前n项和
 2.dp[n]=dp[n-1]+dp[n-2]
 3.dp[0]=0,dp[1]=1
 4.从左到右
 */

public class SolutionOffer4 {
    public int fib(int n) {
        if (n==0)return 0;
        else if(n==1)return 1;
        int MOD = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }
}
