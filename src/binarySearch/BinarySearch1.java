package binarySearch;

/**
 * @Author : Vagrant
 * @Time: 2025-06-04 15:39
 * @File : BinarySearch1.java
 * @Description :二分查找-34. 在排序数组中查找元素的第一个和最后一个位置-2
 * 总体思路：找到第一个>=target的下标，利用二分查找
 * 注意：二分查找中，移动左右下标，应在mid基础上+1/-1，否则进入死循环（如L==R情况下，Mid=L=R，若不+1/-1，则左右下边永远不会动）
 */

public class BinarySearch1 {
    private int lowBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            System.out.println(nums[mid]);
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0 || nums[nums.length - 1] < target) return new int[]{-1, -1};
        int start = lowBound(nums, target);
//        System.out.println(nums[start]);
        if (nums[start] != target) return new int[]{-1, -1};
        int end = lowBound(nums, target + 1);
        return new int[]{start, end - 1};
    }
}
