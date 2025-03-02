package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-01 15:59
 * @File : Solution18.java
 * @Description : 148. 排序链表
 总体思路：
 1.找到中间节点
 2.合并排序
 注意点：找中间节点时，最后slow的前一个节点需要指向null，以分开链表
 */

public class Solution18 {
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = findMiddle(head);
        head = sortList(head);
        head2 = sortList(head2);
        return merge(head, head2);
    }

    public ListNode findMiddle(ListNode listNode) {
//        pre用于断开slow与fast节点
        ListNode pre = listNode;
        ListNode slow = listNode, fast = listNode;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;

            cur.next = left != null ? left : right;
        }

        return dummy.next;
    }
}
