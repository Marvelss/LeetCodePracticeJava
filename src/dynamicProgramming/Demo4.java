package dynamicProgramming;/*
 * @Author : Vagrant
 * @Time: 2025-03-22 16:00
 * @File : Demo4.java
 * @Description : 72. 编辑距离（同583. 两个字符串的删除操作，不同点在步骤2单词不相等情况）
 2.1若单词相等，则dp[i][j]=dp[i-1][j-1]
 2.2若单词不相等，
 ①替换操作：dp[i][j]=dp[i-1][j-1]+1
 ②插入操作：dp[i][j]=dp[i][j-1]+1
 ③删除操作：dp[i][j]=dp[i-1][j]+1
 综上所述，若单词不相等dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
 */

public class Demo4 {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length + 1][w2.length + 1];
        for (int i = 0; i <= w1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= w2.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= w1.length; i++) {
            for (int j = 1; j <= w2.length; j++) {
                if (w1[i - 1] == w2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[w1.length][w2.length];
    }
}
