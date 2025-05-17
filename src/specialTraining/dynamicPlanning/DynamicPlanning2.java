package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-17 20:39
 * @File : DynamicPlanning2.java
 * @Description :动态规划-从记忆化搜索到递推-70. 爬楼梯
 * 1.dp[n]爬到n阶楼梯有几种方法
 * 2.dp[n]=dp[n-1]+dp[n-2]
 * 3.dp[0]=0;dp[1]=1;dp[2]=2;
 * 4.正序
 */

public class DynamicPlanning2 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if (n == 1) return 1;
        if (n == 2) return 2;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
//            System.out.println(dp[i]);
        }
        return dp[n];
    }
}
