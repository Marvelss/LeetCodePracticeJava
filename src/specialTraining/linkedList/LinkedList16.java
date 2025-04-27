package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-27 8:49
 * @File : LinkedList16.java
 * @Description :链表-删除指针-203. 移除链表元素-1
 */

public class LinkedList16 {
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return dummy.next;
    }
}
