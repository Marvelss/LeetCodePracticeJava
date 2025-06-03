package monotonicStack;

import java.util.Stack;

/**
 * @Author : Vagrant
 * @Time: 2025-06-03 15:30
 * @File : MonotonicStack2.java
 * @Description :单调栈-42. 接雨水-3
 * 总体思路：基于739. 每日温度-，获取三个元素计算面积：当前元素（最右边柱子）、栈顶元素（中间柱子，也是记录答案柱子）、栈顶元素的下个元素（最左边柱子）
 * 卡点：没分清楚中间和最左边柱子，栈顶元素为中间元素，该元素的后面一个元素为中间元素的左边元素（根据栈先进后出性质）
 */

public class MonotonicStack2 {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
//            1.取出栈顶元素,并循环比较，若当前元素>栈顶元素
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
//                1.1取出栈顶
                int midIndex = stack.pop();
                if (stack.isEmpty()) break;
                int leftIndex = stack.peek();
//                1.2 放入结果
                int h = Math.min(height[i], height[leftIndex]) - height[midIndex];
                int w = i - leftIndex - 1;
                ans += w * h;
//                System.out.println("下标:" + midIndex + "面积-" + w * h);
            }
//            2.否则当前元素<=栈顶元素,直接放入元素
            stack.push(i);
        }
        return ans;
    }
}
