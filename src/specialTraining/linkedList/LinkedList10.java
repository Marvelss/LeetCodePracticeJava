package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-23 17:11
 * @File : LinkedList10.java
 * @Description :链表-快慢指针-143. 重排链表-2
 * 总体思路；基于翻转链表和取中间节点
 * head（前半段）；head2（倒序后的前半段），循环交叉换节点，当head2.next为空中断
 */

public class LinkedList10 {
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

    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {
        ListNode mid = middleNode2(head);
        ListNode head2 = reverseList(mid);
        while (head2.next != null) {
            ListNode headNxt = head.next;
            ListNode head2Nxt = head2.next;
            head.next = head2;
            head2.next = headNxt;
            head = headNxt;
            head2=head2Nxt;
        }
    }
}
