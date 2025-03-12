package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-12 18:51
 * @File : Solution39.java
 * @Description : 647. 回文子串
 1.i,j:代表下标；dp[i][j]代表在i到j的下标范围是回文子串
 2.在s[i]==s[j]的情况下，有三种方向判断是否回文子串
 2.1 i==j，一定是
 2.2 i与j差1，一定是
 2.3i与j>1,判断dp[i+1][j-1]是否是回文
 3.i从下往上，j从左往后；因为dp[i][j]依靠dp[i+1][j-1]判断
 */

public class Solution39 {
    public int countSubstrings(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[str.length][str.length];
        for (int i = str.length-1; i >=0 ; i--) {
            for (int j = i; j < str.length; j++) {
                if (str[i]==str[j]){
                    if (i==j){
                        dp[i][j]=true;ans++;
                    }
                    else if(j-i==1){
                        dp[i][j]=true;ans++;
                    }
                    else{
                        if (dp[i+1][j-1]){
                            dp[i][j]=true;ans++;
                        }
                    }
                }
            }

        }
        return ans;
    }
}
