package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-10 14:47
 * @File : Solution36.java
 * @Description :394. 字符串解码
 总体思路1(绕晕)：使用一个栈，ans记录结果，tempSubAns记录要计算的字符，cal计算新字符
 总体思路2：使用一个栈，栈根据数字、[与]、其他分四种情况判断（栈只存储数字和字母会清晰很多）
 1.若为数字：currentNum * 10 + (c - '0');
 2.若为[，添加当前字符串，和数字依次入栈
 3.若为]，取以当前字符串为基准，取出数字和字符，左进一步处理，并追加在后
 4.其他情况，直接追加到当前字符串
 */

import java.util.Stack;

public class Solution36 {
    Stack<String> stack = new Stack<>();

    private String cal(String strTemp) {
        String[] strings = strTemp.split("\\[");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < Integer.valueOf(strings[1]); i++) {
            s.append(strings[0]);
        }
        return s.toString();
    }

    public String decodeString(String s) {
        char[] str = s.toCharArray();
        StringBuilder tempS = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            if (String.valueOf(str[i]).equals("]")) {
                StringBuilder tempSubS = new StringBuilder();
                while (!stack.empty()) {
                    String a = stack.pop();
                    if (a.equals("[")) {
                        tempSubS.append(a);
                        break;
                    } else {
                        // 如果当前字符不是数字，弹出栈顶字符
                        tempSubS.append(a);
                    }
                }
                tempSubS.append(stack.pop());
                System.out.println("处理前" + tempSubS);
                String formatStr = cal(tempSubS.toString());
//                tempS.append(formatStr);
                System.out.println("处理后" + formatStr);
//                System.out.println("结果" + tempS);
                System.out.println("剩余栈元素" + stack);
                System.out.println("------------");

//                计算字符串
                if (!stack.empty()) {
                    tempS.setLength(0);
//                    tempS.append(formatStr);
                    tempSubS.setLength(0);
                    stack.push(formatStr);
                } else {
                    tempS.append(formatStr);
                    tempSubS.setLength(0);
                }
            } else {
                stack.push(String.valueOf(str[i]));
                tempS.append(str[i]);
            }
        }
        System.out.println("遍历完" + tempS);
//        若有剩余元素，则补充在后边
        StringBuilder tempSR = new StringBuilder();
        while (!stack.empty()) {
            tempSR.append(stack.pop());
        }
        tempS.append(tempSR.reverse());

        return tempS.toString();
    }

    public String decodeString1(String s) {
        Stack<Object> stack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(currentString.toString());
                stack.push(currentNum);
                currentString = new StringBuilder();
                currentNum = 0;
            } else if (c == ']') {
                int num = (int) stack.pop();
                String prevStr = (String) stack.pop();
                StringBuilder sb = new StringBuilder(prevStr);
                for (int i = 0; i < num; i++) {
                    sb.append(currentString);
                }
                currentString = sb;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution36().decodeString1("abc3[cd]xyz"));
    }
}

