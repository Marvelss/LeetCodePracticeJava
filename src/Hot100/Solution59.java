package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-06 15:16
 * @File : Solution59.java
 * @Description : 5. 最长回文子串
总体思路：中心扩展法-以中心点作为基准向两边扩展，有2种情况（1.中心一个字符；2.中心2个字符）

 */

public class Solution59 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxStart = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
//            j=0/1代表不同中心情况
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
//                回溯,以防下标越界,回退到最后一次左右相等,也就是题解情况
                left++;
                right--;
                if (maxLen < right - left + 1) {
                    maxLen = right - left + 1;
                    maxStart = left;
                }
            }
        }
        return s.substring(maxStart, maxLen + maxStart);
    }
}
