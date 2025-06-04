package binarySearch;

import java.util.Arrays;

/**
 * @Author : Vagrant
 * @Time: 2025-06-04 19:33
 * @File : BinarySearch3.java
 * @Description :二分查找-153. 寻找旋转排序数组中的最小值-3
 * 总体思路：基于162. 寻找峰值，区别在于判断最小值，通过中间值与最后一个元素比较
 */

public class BinarySearch3 {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            // System.out.println(nums[mid]);
            if (nums[mid] > nums[nums.length - 1]) left = mid + 1;
            else if (nums[mid] < nums[nums.length - 1]) right = mid - 1;
            else return nums[left];
        }
        return nums[left];
    }
}
