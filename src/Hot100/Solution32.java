package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-07 15:38
 * @File : Solution32.java
 * @Description : 22. 括号生成
 总体思路：
 1.采用先序遍历，当paths长度为2*n时，收获结果
 2.控制左右括号的数量，应不大于n
 */

import java.util.ArrayList;
import java.util.List;

public class Solution32 {
    private List<String> res = new ArrayList<>();

    private void dfs(String paths, int left, int right, int n) {
        if (left > n || right > left) return;
        if (paths.length() == n * 2) {
            res.add(paths);
            return;
        }

        dfs((paths + "("), left + 1, right, n);
        dfs((paths + ")"), left, right + 1, n);

    }

    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return res;
    }

}
