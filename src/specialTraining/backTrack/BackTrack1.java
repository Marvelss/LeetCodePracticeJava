package specialTraining.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-12 9:03
 * @File : BackTrack1.java
 * @Description :回溯-子集型-17. 电话号码的字母组合-2
 * 总体思路：基于灵神的回溯三问
 * 1.当前操作：path存储字母
 * 2.子问题：构造字符串>=i的部分，获取第一个数字对应的字母（第一层递归）
 * 3.下一个子问题：构造字符串>=i+1的部分，获取第二个数字对应的字母（第二层递归）
 */


public class BackTrack1 {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
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

    private void dfs(char[] digits, int k, int startIndex) {
        if (path.length() == k) {
            ans.add(path.toString());
            return;
        }
//        System.out.println(digits[startIndex]);
        String letter = letterMap[digits[startIndex] - '0'];
        char[] temp = letter.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            path.append(temp[i]);
            dfs(digits, k, startIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        char[] digit = digits.toCharArray();
        if (digits.isEmpty()) return new ArrayList<>();
        dfs(digit, digits.length(), 0);
        return ans;
    }
}
