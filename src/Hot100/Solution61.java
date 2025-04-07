package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-07 16:56
 * @File : Solution61.java
 * @Description : 31. 下一个排列
 总体思路：
1.找到第一个相邻升序对（i，i+1）
2.找到第一个较小的大树A[i]
3.找到第一个大于A[i]的较大的大数A[k]
4.交换A[i]和A[k]
5.[j至end]翻转
 */

public class Solution61 {
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
//        1.找到第一个相邻升序对（i，i+1）
//        从后向前遍历
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
//        2.找到较小的大数
        if (i >= 0) {
            int j = len - 1;
//            3.从后向前找第一个大于较小的大数
            while (nums[j] <= nums[i]) j--;
//            4.交换两个较小和较大的大数
            swap(nums, i, j);
//            5.逆转i之后的所有元素，使其降序
            reverse(nums, i + 1, len - 1);
        }
        else reverse(nums, i + 1, len - 1);
    }
}
