package dynamicProgramming;/*
 * @Author : Vagrant
 * @Time: 2025-03-22 15:34
 * @File : demo3.java
 * @Description : 583. 两个字符串的删除操作
 1.dp[i][j]：以i-1，j-1结尾的字符串删除操作最小次数
 2.若单词相等，则dp[i][j]=dp[i-1][j-1];否则，dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+2)
 3.dp[i][0]=i;dp[0][j]=j，其中dp[i][0]代表：i:下标i-1的单词和0:空字符串
 4.从左到右，从上到下
 */

public class Demo3 {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length + 1][w2.length + 1];
        for (int i = 0; i <= w1.length; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <= w2.length; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <= w1.length; i++) {
            for (int j = 1; j <= w2.length; j++) {
                if (w1[i - 1] == w2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
            }
        }
        return dp[w1.length][w2.length];
    }
}
