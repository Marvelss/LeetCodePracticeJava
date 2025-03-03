package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-03 10:36
 * @File : Solution22.java
 * @Description : 84. 柱状图中最大的矩形

 总体思路：找到左右两边第一个较小值，与接雨水差不多
 注意点：
 数组首位需添加0，以便于stack操作
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution22 {
    private Stack<Integer> stack = new Stack<>();
    private int maxNum = 0;

    public int largestRectangleArea(int[] heights) {
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
                    int h = heightsFilled[mid];
                    int w = right - left - 1;
                    maxNum = Math.max(w * h, maxNum);
                }
            }
            stack.push(i);
        }
        return maxNum;
    }
}
