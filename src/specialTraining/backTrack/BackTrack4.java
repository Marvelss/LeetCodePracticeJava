package specialTraining.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-13 8:00
 * @File : BackTrack4.java
 * @Description :回溯-子集型-131. 分割回文串-2
 * 总体思路：关键点取子串的代码不会,正确代码如下
 *         for (int i = startIndex; i < digits.length(); i++) {
 *             StringBuilder sb = new StringBuilder(digits.substring(startIndex, i + 1));
 *             if (sb.toString().contentEquals(sb.reverse())){
 *                 path.add(sb.toString());
 *                 dfs(digits, k, i + 1);   // 使用i+1而不是startIndex+1，区别在于，后者只取单个字母，前者是子串（从startIndex开始取多个字母）
 *                 path.remove(path.size() - 1);
 *             }
 *         }
 */

public class BackTrack4 {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();


    private void dfs(String digits, int k, int startIndex) {

        if (String.join("", path).length() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < digits.length(); i++) {
            StringBuilder sb = new StringBuilder(digits.substring(startIndex, i + 1));
            if (sb.toString().contentEquals(sb.reverse())){
                path.add(sb.toString());
                dfs(digits, k, i + 1);   // 使用i+1而不是startIndex+1，区别在于，后者只取单个字母，前者是子串（从startIndex开始取多个字母）
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        dfs(s, s.length(), 0);
        return ans;
    }
}
