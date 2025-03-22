package dynamicProgramming;/*
 * @Author : Vagrant
 * @Time: 2025-03-22 15:00
 * @File : demo2.java
 * @Description : 392. 判断子序列(同1143. 最长公共子序列)
 区别在if (w1[i - 1] ！= w2[j - 1])dp[i][j - 1]：t删去一些元素，再对比s是否为t的子序列
 */

public class Demo2 {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) return true;
        if (t.isEmpty()) return false;
        char[] w1 = s.toCharArray();
        char[] w2 = t.toCharArray();
        int[][] dp = new int[w1.length + 1][w2.length + 1];
        for (int i = 1; i <= w1.length; i++) {
            for (int j = 1; j <= w2.length; j++) {
                if (w1[i - 1] == w2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[w1.length][w2.length]);
        return dp[w1.length][w2.length] >= w1.length;

    }
}
