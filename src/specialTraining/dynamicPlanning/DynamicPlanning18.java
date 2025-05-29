package specialTraining.dynamicPlanning;

import java.util.Arrays;

/**
 * @Author : Vagrant
 * @Time: 2025-05-29 8:29
 * @File : DynamicPlanning18.java
 * @Description :动态规划-区间 DP-516. 最长回文子序列
 * 总体思路：
 * 定义：在i和j之前的最长子序列回文数量
 * 若string[i]和string[j]相等,则缩短间距，并数量+2
 * 若string[i]和string[j]不相等,则缩短i/j间距，继续比较
 * 注意：
 * 1.i与j相等时，数量==1
 * 2.i倒叙遍历，因为i依赖后一个数字的内容dp[i][j]=dp[i+1][j]，所以需要倒叙
 */

public class DynamicPlanning18 {
    private int dfs(int i, int j, String s, int[][] dp) {
        if (i == j) return 1;
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j]; // 已经计算过，直接返回
        if (s.charAt(i) != s.charAt(j)) return dp[i][j] = Math.max(dfs(i + 1, j, s, dp), dfs(i, j - 1, s, dp));
        else return dp[i][j] = dfs(i + 1, j - 1, s, dp) + 2;
    }

    public int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < dp.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return dfs(0, n - 1, s, dp);


//      =================================方法2：递推=================================
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                else dp[i][j] = dp[i + 1][j - 1] + 2;
            }
        }
        return dp[0][n - 1];
    }
}
