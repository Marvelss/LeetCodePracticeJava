package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-07 10:41
 * @File : Solution31.java
 * @Description :11. 盛最多水的容器
 总体思路：双指针，从两端分别移动
 关键点：数字小的那个像内移动；
 因为面积由宽和高组成，宽从两别启动，已达最大值；所以高移动短的那个数字，才能取到最大
 */

public class Solution31 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ans = 0;
        while (left < right) {
            // System.out.println(height[left]);
            // System.out.println(height[right]);
            // System.out.println(right - left);
            // System.out.println("---");

            ans = Math.max(Math.min(height[left], height[right]) * (right - left), ans);
            if (height[left] < height[right]) left += 1;
            else right  -= 1;
        }
        return ans;
    }
}
