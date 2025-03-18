package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-18 18:10
 * @File : SolutionOffer3.java
 * @Description : LCR 123. 图书整理 I
 总体思路：反转链表
 */


public class SolutionOffer3 {
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

    public int[] reverseBookList(ListNode head) {
        int[] ans;
        int size = 0;
        ListNode pre = new ListNode();
        while (head != null) {
            ListNode nxtNode = head.next;
            head.next = pre;
            pre = head;
            head = nxtNode;
            size++;
        }
        ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] =pre.val;
            pre = pre.next;

        }
        return ans;
    }
}
