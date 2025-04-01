package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-01 19:54
 * @File : Solution53.java
 * @Description : 34. 在排序数组中查找元素的第一个和最后一个位置
 总体思路：二分查找，闭区间[]情况下，可以找到第一个>=target的元素的下标
 1.查找元素的第一个，二分查找传入target
 2.查找元素的最后一个，（二分查找传入target+1）-1
 注意：二分算法代码编写
 1.mid计算
 2.开闭区别相应代码变化
 3.while循环里,若闭区间[]情况下，优先判断<,nums[mid] < target
 */

public class Solution53 {
    private int binarySearch(int[] nums, int target) {
//        闭区间[]情况
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
            System.out.println("区间:[" + left + "," + right + "]");
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        int end = binarySearch(nums, target + 1);
        return new int[]{start, end - 1};
    }
}
