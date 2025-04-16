package specialTraining.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Vagrant
 * @Time: 2025-04-15 20:50
 * @File : SlidingWindow5.java
 * @Description :滑动窗口-/-2962. 统计最大元素出现至少 K 次的子数组-1
 * 总体思路：基于3. 无重复字符的最长子串
 * 关键点：计算符合题意的子数组个数
 * 当出现符合题意k次的元素时，子数组的右端点到结尾[right,nums.length]都符合题意
 * 以[1, 3, 2, 3, 3]为例，当[1, 3, 2, 3]符合题意时，窗口之后的子数组[1, 3, 2, 3, 3]也符合题意
 */

public class SlidingWindow5 {
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        System.out.println(nums.length);
        Map<Integer, Integer> cnt = new HashMap<>();
        int left = 0;
        int maxNum = getMax(nums);
        for (int right = 0; right < nums.length; right++) {
            cnt.put(nums[right], cnt.getOrDefault(nums[right], 0) + 1);
            if (nums[right]==maxNum){
                while (cnt.get(nums[right]) >= k) {
                    cnt.put(nums[left], cnt.getOrDefault(nums[left], 0) - 1);
                    left++;
                    System.out.println(left);
                    System.out.println(right);
                    System.out.println(nums.length);
                    System.out.println("---------");
                    ans += nums.length - right;
                }
            }
        }
        return ans;
    }
}
