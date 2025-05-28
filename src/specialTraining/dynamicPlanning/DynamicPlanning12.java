package specialTraining.dynamicPlanning;

import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-27 14:10
 * @File : DynamicPlanning12.java
 * @Description :动态规划-最长公共子序列 LCS-1143. 最长公共子序列-2
 * 总体思路：相对于背包问题，多了一个变量的根据选或不选，共四种情况：
 * 1.word1选，word2不选
 * 2.word1不选，word2选
 * 3.word1选，word2选
 * 4.word1不选，word2不选
 * 下一个子问题：当word1[i]==word2[j]才能都选，word1[i]!=word2[j]，才能都不选
 * 状态转移方程为：if (word1.charAt(i) == word2.charAt(j))
 *                     dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]), dp[i][j] + 1);
 *                 else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
 */

public class DynamicPlanning12 {
    public int longestCommonSubsequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]), dp[i][j] + 1);
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[m][n];
    }
}
