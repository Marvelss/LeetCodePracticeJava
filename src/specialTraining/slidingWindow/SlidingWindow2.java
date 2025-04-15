package specialTraining.slidingWindow;

/**
 * @Author : Vagrant
 * @Time: 2025-04-15 19:42
 * @File : SlidingWindow2.java
 * @Description :滑动窗口-/-3. 无重复字符的最长子串-3(又是卡在while,判断重复字符不应该用if,因为可能有连续重复情况)
 * 总体思路:滑动窗口
 * 1.移动(right遍历,若无重复则一直移动)
 * 2.判断重复数组(使用哈希表记录,可用数组代替)
 */

public class SlidingWindow2 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] cnt = new int[128];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            cnt[s.charAt(right)]++;
            while (cnt[s.charAt(right)] > 1) {
                cnt[s.charAt(left)]--;
                left++;
            }
            System.out.println(right);
            System.out.println(left);
            System.out.println("----------");
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
