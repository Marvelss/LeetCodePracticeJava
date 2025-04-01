package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-01 20:27
 * @File : Solution54.java
 * @Description : 33. 搜索旋转排序数组
 总体思路：在二分查找的基础上，利用末尾元素，再加一步骤判断移动left还是right
 1.存在递增和递减
 1.1目标在右半部分，mid在左半部分:target<=末尾元素，nums[mid]>末尾元素
 1.2目标在左部分，mid在右半部分:target>末尾元素，nums[mid]<=末尾元素
 2.全是递增或递减:正常二分查找
 */

public class Solution54 {
    public int search(int[] nums, int target) {
//        闭区间[]情况
        int left = 0;
        int right = nums.length - 1;
        int end = nums[right];
        System.out.println("区间:[" + left + "," + right + "]");
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > end && target <= end) {
                left = mid + 1;
            } else if (nums[mid] <= end && target > end) {
                right = mid - 1;
            } else {
                if (nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
            System.out.println("区间:[" + left + "," + right + "]");
        }
        if (left == nums.length || nums[left] != target) return -1;
        return left;
    }
}
