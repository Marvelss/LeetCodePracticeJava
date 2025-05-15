package specialTraining.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-15 14:01
 * @File : BackTrack9.java
 * @Description :回溯-组合型与剪枝-22. 括号生成-2
 * 1.递归参数：数字n、当前括号总数、当前左括号个数、path
 * 2.终止添加：i==n*2
 * 3.添加左括号/添加右括号
 * 关键点：添加左、右括号的时机
 * 添加左括号：open<n
 * 添加右括号：i-open<open
 */


public class BackTrack9 {
    private List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    private void backTracing(int n, int i, int open) {
        if (i == n * 2) {
            res.add(path.toString());
            return;
        }
        if (open < n) {
            path.append("(");
            backTracing(n, i + 1, open + 1);
            path.deleteCharAt(path.length() - 1);
        }
        if (i - open < open) {
            path.append(")");
            backTracing(n, i + 1, open);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        backTracing(n, 0, 0);
        return res;
    }
}
