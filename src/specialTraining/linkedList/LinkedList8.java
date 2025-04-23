package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-23 15:54
 * @File : LinkedList8.java
 * @Description :链表-快慢指针-141. 环形链表-3
 * 总体思路：快慢指针：一直循环，若相遇节点相同则有环；若无环则自动会结束循环
 * 卡点：fast移动时会存在空指针现象
 * 条件应为    while (fast != null && fast.next != null) ；fast 指针每次移动两步包含了slow情况
 * 而不是     while (fast.next.next != null && slow.next != null)
 */

public class LinkedList8 {
    static class ListNode {
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
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
