package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-22 13:52
 * @File : LinkedList4.java
 * @Description :链表-反转链表-24. 两两交换链表中的节点
 * 总体思路：基于反转链表-25. K 个一组翻转链表，当k=2时即为答案
 */

public class LinkedList4 {
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
    public ListNode reverseKGroup(ListNode head, int k) {
//        计算长度
        ListNode temp = head;
        int cnt = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p0 = dummy;
        while (temp!= null) {
            cnt++;
            temp = temp.next;
        }
        while (cnt >= k) {
            cnt -= k;
            ListNode pre = null;
            ListNode cur = p0.next;
            ListNode nxt;
            // System.out.println(cur.val);
            for (int i = 0; i < k; i++) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head,2);
    }
}
