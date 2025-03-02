package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-02 15:56
 * @File : Solution20.java
 * @Description : 739. 每日温度
 总体思路：创建栈，存放下标
 以单调递增为例存放情况
 1.若temperatures[i] < temperatures[stack.peek()，存入
 2.若=，存入
 3.若>，且stack不为空，收割结果
 3.1当前下标i-栈顶下标
 3.2弹出
 3.3循环该情况
 4.最后都要存入一个元素，使得stack永不空
 */

import java.util.Stack;

public class Solution20 {
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] index = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    index[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
            }
            stack.push(i);

        }

        return index;
    }
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] index = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                index[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return index;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] index = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    index[i] = j - i;
                    break;
                } else index[i] = 0;
            }
        }
        return index;
    }


}
