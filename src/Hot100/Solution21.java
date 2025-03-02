package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-02 20:08
 * @File : Solution21.java
 * @Description : 42. 接雨水
 总体思路：实现单调递增栈，按行计算面积
 中间节点栈口元素；右边元素：当前要入栈的元素；左边元素，栈口的第二个元素
 计算公式：
 高：左右边的最小高度-中间的高
 宽：右边的下标-左边下标+1
 */


import java.util.Stack;

public class Solution21 {

    public int trap(int[] height) {
        Stack<Integer> stack1 = new Stack<>();
        int res = 0;
        if (height.length <= 2) return 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack1.empty() && height[i] > height[stack1.peek()]) {
                int mid = stack1.peek();
                stack1.pop();
                if (!stack1.empty()) {
                    int h = Math.min(height[i], height[stack1.peek()]) - height[mid];
                    int w = i - stack1.peek() - 1;
                    res += h * w;
                }
            }
            stack1.push(i);
        }
        return res;
    }
}
