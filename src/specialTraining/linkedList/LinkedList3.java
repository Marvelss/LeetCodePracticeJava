package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-21 19:20
 * @File : LinkedList3.java
 * @Description :链表-反转链表-25. K 个一组翻转链表-3
 * 总体思路：
 * 关键点：
 * 1.判断是否剩余节点
 * 2.如何联接k个组：记录上一段的p0，从而衔接
 */

public class LinkedList3 {
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
}
