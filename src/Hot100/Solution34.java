package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-08 16:31
 * @File : Solution34.java
 * @Description :301. 删除无效的括号
 总体思路：
 1.先统计删除多少左括号和右括号
 2.遇到左括号和右括号：取或不取两种情况
 取为符合题意，不取，则为括号存在多余
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution34 {
    public List<String> removeInvalidParentheses(String s) {
//     统计要删除多少左括号和右括号数
        int leftExtra = 0, rightExtra = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') leftExtra++;
            else if (c == ')') {
                if (leftExtra == 0) rightExtra++;
                else leftExtra--;
            }
        }

//    若已合法，则返回
        if (leftExtra == 0 & rightExtra == 0) return Arrays.asList(s);
        List<String> ans = new ArrayList<>();

        dfs(ans, s, 0, 0, new StringBuilder(), leftExtra, rightExtra, 0);


        return ans;
    }

    public void dfs(List<String> ans, String s, int i, int diff, StringBuilder sb, int leftExtra, int rightExtra, int status) {
        if (i == s.length()) {
            if (diff == 0 && isValid(sb)) ans.add(sb.toString());
            return;
        }
        char c = s.charAt(i);
        if (c == '(') {
            if ((status & 1) == 0) {
                sb.append(c);
                dfs(ans, s, i + 1, diff +1, sb, leftExtra, rightExtra, 0);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (leftExtra > 0) {
                dfs(ans, s, i + 1, diff, sb, leftExtra - 1, rightExtra, status | 1);
            }
        } else if (c == ')') {
            if (diff > 0 && (status & 2) == 0) {
                sb.append(c);
                dfs(ans, s, i + 1, diff - 1, sb, leftExtra, rightExtra, 0);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (rightExtra > 0) dfs(ans, s, i + 1, diff, sb, leftExtra, rightExtra - 1, status | 2);

        } else {
            sb.append(c);
            dfs(ans, s, i + 1, diff, sb, leftExtra, rightExtra, 0);
            sb.deleteCharAt(sb.length()-1);
        }


    }

    private boolean isValid(StringBuilder sb) {
        // 判断括号是否合法
        int left = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    return false;
                } else {
                    left--;
                }
            }
        }
        return left == 0;
    }
}
