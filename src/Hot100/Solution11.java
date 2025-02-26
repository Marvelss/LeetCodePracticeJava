package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-26 10:10
 * @File : Solution11.java
 * @Description : 回溯-17. 电话号码的字母组合

 注意letterMap[]下标与相应字母的对应;
 */

import java.util.*;

public class Solution11 {
    List<String> ans = new ArrayList<>();
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        char[] d = digits.toCharArray();
        StringBuffer sb = new StringBuffer();
        dfs(d, 0, sb, ans);
        return ans;
    }

    public void dfs(char[] d, int begin, StringBuffer sb, List<String> ans) {
        if (begin == d.length) {
            ans.add(sb.toString());
            return;
        }
        char temp = d[begin];
        String letters = letterMap[temp - '0'];
        for (int j = 0; j < letters.length(); j++) {
            sb.append(letters.charAt(j));
            dfs(d, begin + 1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
