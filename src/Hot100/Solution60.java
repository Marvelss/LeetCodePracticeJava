package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-07 9:24
 * @File : Solution60.java
 * @Description : 10. 正则表达式匹配(抄了一遍)
 情况1：s[i-1]与p[j-1]是否匹配
 情况1.2：p[j-1]=='*'，且s[i-1]与p[j-2]是否匹配
 */

public class Solution60 {
    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        boolean[][] dp = new boolean[cs.length + 1][cp.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < cp.length + 1; i++) {
            if (cp[i - 1] == '*') dp[0][i] = dp[0][i - 2];
        }

        for (int i = 1; i < cs.length + 1; i++) {
            for (int j = 1; j < cp.length + 1; j++) {
//                文本串和模式串末尾字符能匹配上
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp[j - 1] == '*') {        // 模式串末尾是*
//                    模式串*的前一个字符跟文本串末尾匹配上
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]         // *匹配0次情况
                                || dp[i - 1][j];         // *匹配1次或>=2次情况
                    } else dp[i][j] = dp[i][j - 2];          // *匹配0次情况
                }
            }
        }
        return dp[cs.length][cp.length];
    }
}
