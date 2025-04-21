package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-17 15:34
 * @File : LinkedList2.java
 * @Description :链表-反转链表-206. 反转链表-4
 * 总体思路：基于206. 反转链表：当反转链表后结束的状态是：pre指向末尾阶段；cur指向末尾节点的下一个节点（空节点）
 * 1.找到需要翻转的前一个节点p0
 * 2.翻转题目要求的节点
 * 3.连接未翻转和已翻转链表：p0.next=pre；p0.next.next=cur
 */

public class LinkedList2 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            // System.out.println(p0.val);
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;
        // System.out.println(cur.val);

        for (int i = 0; i < right - left + 1; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            // System.out.println(pre.val);

        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
}
