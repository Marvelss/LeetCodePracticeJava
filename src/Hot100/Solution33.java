package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-08 11:06
 * @File : Solution33.java
 * @Description : 287. 寻找重复数
 总体思路：将下标映射为对应的nums值，使思路与142.环形链表II一致，
 1.先找到相遇点
 2.后从相遇点与0开始，第二次相交则为重复值
 */

public class Solution33 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast=nums[nums[fast]];
        }

        int pre = 0;
        int cur = slow;
        while (pre!=cur){
            pre=nums[pre];
            cur=nums[cur];
        }
        return pre;
    }
}
