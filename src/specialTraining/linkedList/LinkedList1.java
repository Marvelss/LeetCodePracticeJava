package specialTraining.linkedList;

import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-04-17 14:11
 * @File : LinkedList1.java
 * @Description :链表-反转链表-206. 反转链表-2
 * 关键点：
 * 1.pre=null：用来dummy虚拟头节点为了方便末尾指向null
 * 2.cur=head：通过cur来引用，从而改动节点而不影响原节点
 */

public class LinkedList1 {
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
        if (head==null)return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // System.out.println(cur.val);
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
