package binarySearch;

/**
 * @Author : Vagrant
 * @Time: 2025-06-04 20:53
 * @File : BinarySearch4.java
 * @Description :二分查找-154. 寻找旋转排序数组中的最小值 II-2（朦朦胧胧）
 * 基于二分查找-153. 寻找旋转排序数组中的最小值，因存在重复元素，所以会出现nums[mid] 与数组末尾元素 nums[n−1] 相同的情况
 * 解决办法：去除判断最后一个元素，若该值为最小值，则nums[mid]也为最小值；否则不为最小值，也不是题解
 */

public class BinarySearch4 {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
//        左闭，右开
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            // System.out.println(nums[mid]);
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right -= 1;
        }
        return nums[right];
    }
}
