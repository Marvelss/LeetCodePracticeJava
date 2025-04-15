package specialTraining.slidingWindow;

/**
 * @Author : Vagrant
 * @Time: 2025-04-15 19:59
 * @File : SlidingWindow3.java
 * @Description :滑动窗口-/-3. 无重复字符的最长子串-3(卡点在不知道符合乘积的子数组个数怎么算,弄清关键点的理解)
 * 总体思路:基于209. 长度最小的子数组
 * 关键点:
 * 1.理解如何计算符合题意乘积的子数组个数:符合题意子数组个数=nus[left]到以 nums[right] 为结尾子数组数量
 * 2.所以答案每次增量的值为right - left + 1,若[l,r]内乘积的子数组个数符合题意,则[l+1,r]都符合题意
 */

public class SlidingWindow3 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int ans = 0;
        int left = 0;
        int product = 1;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            System.out.println(product);
            System.out.println(k);
            System.out.println("对比");
            while (product >= k) {
                System.out.println(left);
                System.out.println(right);
                System.out.println(">=");
                product /= nums[left];
                left++;
            }
            ans += right - left + 1;

        }
        return ans;
    }
}
