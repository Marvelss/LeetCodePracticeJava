package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-27 9:33
 * @File : LinkedList18.java
 * @Description :链表-删除指针-2487. 从链表中移除节点-2
 * 总体思路：先反转链表，在删除比当前值小的节点，再反转链表
 * 代码感觉：在链表中，删除节点代码为cur.next = cur.next.next;保留节点代码为：cur=cur.next
 */

public class LinkedList18 {
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

    public ListNode removeNodes(ListNode head) {
        ListNode head1 = reverseList(head);
        ListNode cur = head1;
        while (cur.next != null) {
            if (cur.val > cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return reverseList(head1);
    }

}
