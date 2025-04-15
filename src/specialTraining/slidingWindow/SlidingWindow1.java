package specialTraining.slidingWindow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author : Vagrant
 * @Time: 2025-04-15 10:31
 * @File : SlidingWindow1.java
 * @Description :滑动窗口-/-209. 长度最小的子数组-3（卡点）
 * 总体思路：滑动窗口，right向左遍历，当子数组总和>=target时，left++，注意用while持续改变left缩小窗口
 * 关键卡点：在 sum >= target 时使用 while 循环而不是 if，确保尽可能缩小窗口
 * 若if，无法通过该测试用例[2,3,1,2,4,3]，target=7
 * 因为最后一次循环right到达末尾元素时，left不一定是最后末尾元素，需要用while持续移动判断
 */

public class SlidingWindow1 {

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;
        while (right <= nums.length - 1) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left);
                System.out.println(left);
                System.out.println(right);
                System.out.println(">=");
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
