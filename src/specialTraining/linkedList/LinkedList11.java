package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-24 13:56
 * @File : LinkedList11.java
 * @Description :链表-快慢指针-234. 回文链表-1
 * 总体思路：基于翻转链表和取中间节点
 * 取中间节点并反转链表后，一一对应判断值是否相等
 */

public class LinkedList11 {
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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode2(head);
        ListNode head2 = reverseList(mid);
        while (head2 != null) {
            if (head.val!=head2.val)return false;
            System.out.println(head.val);
            System.out.println(head2.val);
            head=head.next;
            head2=head2.next;
        }
        return true;
    }
}
