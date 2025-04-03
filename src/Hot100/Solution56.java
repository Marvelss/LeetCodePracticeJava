package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-03 9:31
 * @File : Solution56.java
 * @Description : 3. 无重复字符的最长子串
 总体思路：不固定滑动窗口
 1.右侧元素进入窗口
 2.更新窗口：
 2.1移除左侧元素
 2.2缩小窗口
 2.3更新结果
 */

import java.util.HashMap;
import java.util.Map;

public class Solution56 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        int left = 0;
        int[] cnt = new int[128];
        for (int right = 0; right < chars.length; right++) {
            cnt[chars[right]]++;
            while (cnt[chars[right]] > 1) {
                cnt[chars[left]]--;
                left++;

            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
