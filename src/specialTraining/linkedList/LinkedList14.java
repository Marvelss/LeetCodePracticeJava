package specialTraining.linkedList;

import Hot100.Solution10;

/**
 * @Author : Vagrant
 * @Time: 2025-04-26 20:34
 * @File : LinkedList14.java
 * @Description :链表-删除指针-19. 删除链表的倒数第 N 个结点-1
 * 总体思路1：基于反转指针，反转一次后，删除正数第N个节点，然后反转
 * 注意：可能删除第一个节点，所以需要dummy节点,并注意移动第N个节点时的边界值
 * 总体思路2：使用快慢指针：right先从头走n步，然后left，right同步走，知道right到末尾
 * 因为right和left的距离始终为n，所以当right走到末尾时，left恰好为倒数第n个节点
 */

public class LinkedList14 {
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

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        ListNode dummy = new ListNode();
        dummy.next = reverseList(head);
        ListNode cur = dummy;
        for (int i = 0; i < n - 1; i++) {
            // System.out.println(cur.val);
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return reverseList(dummy.next);

    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode right = head;
        ListNode left = dummy;
        for (int i = 0; i < n; i++) {
            System.out.println(right.val);
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
            System.out.println(left.val);

        }
        left.next = left.next.next;
        return dummy.next;

    }

}
