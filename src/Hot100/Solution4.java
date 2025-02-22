package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-22 19:27
 * @File : Solution4.java
 * @Description : 141. 环形链表

 思路：快慢指针，快指针比慢指针多走一步，若出现含循环，则一定会相遇，否则跳出循环就表示无环
 */

import java.util.ArrayList;

public class Solution4 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = new ListNode().next = head;
        ListNode slow = new ListNode().next = head;
        while (fast != null) {
            fast=fast.next;
            if (fast!=null){
                fast=fast.next;
            }
            if (fast==slow)return true;
            slow=slow.next;
        }
        return false;
    }
}
