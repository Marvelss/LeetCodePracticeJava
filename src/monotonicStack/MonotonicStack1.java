package monotonicStack;

import java.util.Stack;

/**
 * @Author : Vagrant
 * @Time: 2025-06-03 9:53
 * @File : MonotonicStack1.java
 * @Description :单调栈-739. 每日温度-1
 * 总体思路：利用单调栈，每次保存
 * 注意入栈时，while循环判断是否需要入栈，而不是if单次
 */

public class MonotonicStack1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
//            1.取出栈顶元素,并循环比较，若当前元素>栈顶元素
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
//                1.1取出栈顶
                int ansIndex = stack.pop();
//                1.2 放入结果
                ans[ansIndex] = i - ansIndex;
                System.out.println("下标:" + ansIndex + "答案-" + i + "-" + ansIndex);
            }
//            2.否则当前元素<=栈顶元素,直接放入元素
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        MonotonicStack1 solution = new MonotonicStack1();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
    }
}
