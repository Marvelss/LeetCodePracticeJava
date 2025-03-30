package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-30 15:41
 * @File : Solution49.java
 * @Description : 221. 最大正方形(很多细节比较经典，值得反复刷)
 1.dp[i+1][j+1],第i行第j列的最大值正方形边长
 2.dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])  (左边，上边，左上方三个方向)
 3.dp[i][0]和dp[0][j]赋为0
 4.从左到右，从上到下
 细节：
 1.dp的定义为什么dp[i+1][j+1]，相应初始化及状态转移的变化
 2.为什么要多一个判断if (matrix[i][j] == '1')，答： 只有 '1' 才为正方形，符合题意
 3.状态转移公式中木头效应
 4.为什么side要取最大值
 */

public class Solution49 {
    public int maximalSquare(char[][] matrix) {
        int side = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int left = dp[i + 1][j];
                    int top = dp[i][j + 1];
                    int leftTop = dp[i][j];
                    dp[i + 1][j + 1] = Math.min(Math.min(left, top), leftTop) + 1;
                    side = Math.max(side, dp[i + 1][j + 1]);
                    System.out.println(dp[i][j]);
                }
            }
        }
        return side * side;
    }
}
