package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-23 15:25
 * @File : SolutionOffer6.java
 * @Description : LCR 127. 跳跃训练(同爬楼梯)
 */

public class SolutionOffer6 {
    public int trainWays(int num) {
        if (num <= 1) return 1;
        int[] dp = new int[num+1];
        int max = 1000000007;
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%max;
        }
        return dp[num];
    }
}
