package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-11 20:56
 * @File : Solution38.java
 * @Description : 64. 最小路径和(一次过)
 1.m：行;n:列;dp[m][n]：第m行n列的最小路径和
 2.dp[x][y]=min(dp[x-1][y],dp[x][y-1])+grid[x][y]
 3.第一行，第一列都初始化
 4.从左到右
 */

import java.util.ArrayList;

public class Solution38 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int temp = 0;
        for (int i = 0; i < grid.length; i++) {
            temp += grid[i][0];
            dp[i][0] = temp;
            // System.out.println(i + "," + 0+ "---->" + dp[i][0]);

        }
        temp = 0;
        for (int i = 0; i < grid[0].length; i++) {
            temp += grid[0][i];
            dp[0][i] = temp;
            // System.out.println(0 + "," +i+ "---->" + dp[0][i]);

        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                // System.out.println(i + "," + j + "---->" + dp[i][j]);

                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }


        return dp[grid.length-1][grid[0].length-1];
    }
}
