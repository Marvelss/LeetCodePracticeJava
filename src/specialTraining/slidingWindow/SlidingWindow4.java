package specialTraining.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Vagrant
 * @Time: 2025-04-15 20:36
 * @File : SlidingWindows4.java
 * @Description :滑动窗口-/-2958. 最多 K 个重复元素的最长子数组-1
 * 总体思路:基于3. 无重复字符的最长子串
 * 1.修改哈希表的存储
 * 2.将出现频率改为k
 */

public class SlidingWindow4 {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt.put(nums[right], cnt.getOrDefault(nums[right], 0) + 1);
            while (cnt.get(nums[right]) > k) {
                cnt.put(nums[left], cnt.getOrDefault(nums[left], 0) - 1);
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
