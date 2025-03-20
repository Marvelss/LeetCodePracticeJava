package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-20 9:15
 * @File : SolutionOffer5.java
 * @Description : LCR 125. 图书整理 II
 总体思路（使用LinkList比Stack效率高）：
 1.appendTail：直接放入元素即可
 2.deleteHead：
 2.1先看OUT栈是否为空，有则弹出末尾元素
 2.2看In栈是否为空，是则返回-1
 2.3In栈元素放入Out栈
 2.4返回Out末尾元素
 */


import java.util.LinkedList;
import java.util.Stack;

class SolutionOffer5 {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public SolutionOffer5() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        while (!stackIn.empty()) stackOut.push(stackIn.pop());
        int headValue = stackOut.empty() ? -1:stackOut.pop() ;
        while (!stackOut.empty()) stackIn.push(stackOut.pop());
        return headValue;
    }
}
//class SolutionOffer5 {
//    LinkedList<Integer> stackIn;
//    LinkedList<Integer> stackOut;
//
//    public SolutionOffer5() {
//        stackIn = new LinkedList<>();
//        stackOut = new LinkedList<>();
//    }
//
//    public void appendTail(int value) {
//        stackIn.add(value);
//    }
//
//    public int deleteHead() {
//        if (!stackOut.isEmpty())return stackOut.removeLast();
//        if (stackIn.isEmpty())return -1;
//        while (!stackIn.isEmpty()) stackOut.add(stackIn.removeLast());
//        return stackOut.removeLast();
//    }
//}