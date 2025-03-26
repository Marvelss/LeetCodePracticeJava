package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-26 7:46
 * @File : SolutionOffer12.java
 * @Description : LCR 136. 删除链表的节点
 注意：dummy.next=head，说明dummy下一个节点指向head，直接在head上操作删改，所以会影响head的结构
 */

import Hot100.Solution18;
import Hot100.Solution44;

public class SolutionOffer12 {
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

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val==val)return head.next;
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (dummy.next.val != val) {
            dummy = dummy.next;
        }
        dummy.next=dummy.next.next;
        return head;
    }
}
