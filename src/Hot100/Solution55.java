package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-02 22:30
 * @File : Solution55.java
 * @Description : 438. 找到字符串中所有字母异位词
 总体思路：固定滑动窗口
 1.进入窗口，添加右侧下标
 2.更新答案，若窗口内元素==p，则保存窗口最左边下标
 3.离开窗口，移除左侧下标
 注意：窗口元素不足情况left = right - p.length() + 1; 跳过该循环
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution55 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26];
        int[] cntS = new int[26];
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++;
        }

        for (int right = 0; right < s.length(); right++) {
//            1.进入窗口
            cntS[s.charAt(right) - 'a']++;
//            注意窗口不足情况
            int left = right - p.length() + 1;
            if (left < 0) continue;
//            2.更新答案
            if (Arrays.equals(cntP, cntS)) ans.add(left);
//            3.元素窗口
            cntS[s.charAt(left) - 'a']--;
        }
        return ans;
    }
}
