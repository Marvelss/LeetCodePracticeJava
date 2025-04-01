package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-01 18:44
 * @File : Solution52.java
 * @Description : 240. 搜索二维矩阵 II
 总体思路：由题目的行、列性质得到将矩阵旋转45度看作为二叉搜索数
 1.若根节点>目标值，i--；否则j++
 2.边界情况，可以通过while (i >= 0 && j <= row)把控
 */

public class Solution52 {
    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length==1)return matrix[0][0]==target;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int j = 0;
        int i = col;
        while (i >= 0 && j <= row) {
            System.out.println("第" + j + "行，第"+i+"列");
            int root = matrix[j][i];
            if (root > target) i--;
            else if (root < target) j++;
            else if (root == target) return true;
            System.out.println(root);
        }
        return false;
    }
}
