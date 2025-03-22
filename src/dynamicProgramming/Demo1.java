package dynamicProgramming;/*
 * @Author : Vagrant
 * @Time: 2025-03-20 16:30
 * @File : demo1.java
 * @Description : 1143. 最长公共子序列
 1.dp[i][j]代表以(0,i-1)，(0,j-1)结尾的最长公共子序列
 2.若单词相等，则dp[i][j]=dp[i-1][j-1];否则，dp[i][j]=max(dp[i-1][j],dp[i][j-1])
 3.dp[i][0]=0;dp[0][j]=0
 4.从上往下，从左往右
 */

public class Demo1 {
    public int longestCommonSubsequence(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length+1][w2.length+1];
        for (int i = 1; i <= w1.length; i++) {
            for (int j = 1; j <= w2.length; j++) {
                if (w1[i-1] == w2[j-1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[w1.length][w2.length];
    }
}
