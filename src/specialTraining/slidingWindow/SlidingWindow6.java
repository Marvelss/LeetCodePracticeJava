package specialTraining.slidingWindow;

/**
 * @Author : Vagrant
 * @Time: 2025-04-16 19:49
 * @File : SlidingWindow6.java
 * @Description :滑动窗口-/-2302. 统计得分小于 K 的子数组数目-3
 * 总体思路：基于3. 无重复字符的最长子串
 * 关键点（卡点）：未推出窗口移动计算公式
 * 不用按照题解的计算公式，只需要控制sum即可，然后*个数（right-left+1）
 */

public class SlidingWindow6 {
    public long countSubarrays(int[] nums, long k) {
        if (k == 0) return 0;
        long ans = 0;
        int left = 0;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            System.out.println(k);
            System.out.println("对比");
            while (sum * (right - left + 1) >= k) {
                System.out.println(left);
                System.out.println(right);
                System.out.println(">=");
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
