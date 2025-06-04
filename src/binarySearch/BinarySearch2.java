package binarySearch;

/**
 * @Author : Vagrant
 * @Time: 2025-06-04 16:44
 * @File : BinarySearch2.java
 * @Description :二分查找-162. 寻找峰值-2
 * 总体思路：基于34. 在排序数组中查找元素的第一个和最后一个位置，通过mid来划分峰值的左/右侧区域
 * 区别在于，nums[mid] < nums[mid + 1]，则左侧为峰值的左区域
 */

public class BinarySearch2 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int left = 0;
        int right = nums.length - 2;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            // System.out.println(nums[mid]);
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
