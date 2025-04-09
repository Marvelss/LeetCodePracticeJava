package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-09 16:29
 * @File : Solution64.java
 * @Description : 32. 最长有效括号
 总体思路
 1.dp[i]:以i为结尾的最长有效子串长度
 2.分情况判断转移方程，看四种情况：s[i]、s[i-1]、s[i-2]、s[i-dp[i-1]-1]
 2.1 s[i]=='(':dp[i]=0
 2.2 若s[i]==')'，再分情况讨论

 2.2.1若s[i-1]=='('，再根据s[i-2]讨论
 a.若s[i-2]不存在，dp[i]=2
 b.若s[i-2]存在，dp[i]=dp[i-2]+2

 2.2.2若s[i-1]==')'，再根据s[i-dp[i-1]-1]讨论
 a.若s[i-dp[i-1]-1]为空或==')'，dp[i]=0
 b.若s[i-dp[i-1]-1]=='('
 b.1 且s[i-dp[i-1]-2]存在，dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2
 b.2 且不存在，dp[i]=dp[i-1]+2

 */

public class Solution64 {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        char[] tempS = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < tempS.length; i++) {
            if (tempS[i] == '(') dp[i] = 0;
            else {
                if (tempS[i - 1] == '(') {
                    if (i - 2 < 0) dp[i] = 2;
                    else dp[i] = dp[i - 2] + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && tempS[i - dp[i - 1] - 1] == '(') {
                    if (i - dp[i - 1] - 2 >= 0) dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    else dp[i] = dp[i - 1] + 2;
                }

            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
