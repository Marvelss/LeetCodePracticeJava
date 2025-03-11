package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-11 18:27
 * @File : Solution37.java
 * @Description :48. 旋转图像
 总体思路：
 1.选定旋转起始点0,0
 2.结束旋转点:
 2.1若长度为偶数则，行：n/2,列：n/2
 2.2奇数：行：n/2，列：(n+1)/2
 */

public class Solution37 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
    }
}
