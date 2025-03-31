package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-31 17:57
 * @File : Solution51.java
 * @Description : 85. 最大矩形
 1.总体思路：基于84. 柱状图中最大的矩形，遍历每行调用计算
 2.卡点：二维矩阵的遍历不熟练
 */

import java.util.Stack;

public class Solution51 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxNum = 0;
        int[] heightsFilled = new int[heights.length + 2];
        heightsFilled[0] = 0;
        System.arraycopy(heights, 0, heightsFilled, 1, heights.length);
        heightsFilled[heightsFilled.length - 1] = 0;
        for (int i = 0; i < heightsFilled.length; i++) {
            while (!stack.empty() && heightsFilled[i] < heightsFilled[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.empty()) {
                    int left = stack.peek();
                    int right = i;
                    maxNum = Math.max(maxNum, (right - left - 1) * heightsFilled[mid]);
                }
            }
            stack.push(i);
        }
        return maxNum;
    }

    private int[] getHeight(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];

        for (int i = 0; i < cols; i++) {
            int len = 0;
            for (int j = rows - 1; j >= 0; j--) {
                if (matrix[j][i] == '1') {
                    len++;
                } else {
                    break;
                }
            }
            height[i] = len;
        }

        return height;
    }

    public int maximalRectangle(char[][] matrix) {
        int maxSize = 0;
        char[][] matrixTemp = new char[matrix.length][matrix[0].length];
        int[] height = new int[matrix[0].length];
        for (char[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[j] == '1') height[j]++;
                else height[j] = 0;
            }
            maxSize = Math.max(maxSize, largestRectangleArea(height));
            // for (int i1 : height) {
            //     System.out.print(i1 + " ");
            // }

            // System.out.println(maxSize);
            // System.out.println("-------------");

        }
        return maxSize;
    }

}
