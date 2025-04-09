package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-09 9:53
 * @File : Solution62.java
 * @Description : 581. 最短无序连续子数组
 总体思路：从题目性质入手
 1.区分数组情况
 1.1有序
 1.2有序+无序+有序
 2.针对1.2，进一步判断如何确定无序边界
 3.引入Max和Min
 3.1作用：分别确定无序数组的右、左边界
 3.2具体移动：以确定右边界为例，正序遍历，当出现当前值不符合最大值时，即为可能的右边界，直到遍历结束；左边界确定通过逆序遍历同理
 */

public class Solution62 {
    public int findUnsortedSubarray(int[] nums) {
        int MaxNum = Integer.MIN_VALUE;
        int MinNum = Integer.MAX_VALUE;
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < MaxNum) start = i;
            MaxNum = Math.max(nums[i], MaxNum);
            System.out.println("最大值：" + MaxNum + "----------右边界" + start);
        }
        System.out.println("********************************");
        for (int i = nums.length - 1; i > -1; i--) {
            if (nums[i] > MinNum) end = i;
            MinNum = Math.min(nums[i], MinNum);
            System.out.println("最小值：" + MinNum + "----------左边界" + end);
        }


        return start + end == 0 ? 0 : start - end + 1;
    }
}
