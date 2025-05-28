package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-27 21:04
 * @File : DynamicPlanning13.java
 * @Description :动态规划-最长公共子序列 LCS-72. 编辑距离-2
 * 卡点：不能将插、删、替换的行为总结成状态转为方程,删除dp[i-1][j]；替换：dp[i-1][j-1]；添加：dp[i][j-1]
 * 卡点2：字符串长度不对齐，解决：初始化时前0行，和前0列初始化为对应的行与列（插入操作）
 * 状态转移方程：
 * 若word1.charAt(i) == word2.charAt(j),dp[i + 1][j + 1] = dp[i][j]
 * 若word1.charAt(i) != word2.charAt(j),dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
 */

public class DynamicPlanning13 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化第一行和第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // 将 word1 的前 i 个字符转换为空字符串需要 i 次删除操作
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // 将空字符串转换为 word2 的前 j 个字符需要 j 次插入操作
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
            }
        }
        return dp[m][n];
    }
}
