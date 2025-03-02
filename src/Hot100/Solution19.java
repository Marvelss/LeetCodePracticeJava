package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-02 15:44
 * @File : Solution19.java
 * @Description : 155. 最小栈
 总体思路：使用两个栈，一个stack存储所有元素，一个minStack存储最小元素
 1.push：stack入栈，传入元素若<=minStack的顶端元素，则也入栈
 2.pop：stack弹出，stack弹出的元素若==minStack的顶端元素，则也弹出
 3.top：获取stack顶部元素
 4.getMin：获取minStack顶部元素
 */

import java.util.Stack;

public class Solution19 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public Solution19() {
        stack=new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()||minStack.peek()>=val)minStack.push(val);
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek()))minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
return minStack.peek();
    }
}
