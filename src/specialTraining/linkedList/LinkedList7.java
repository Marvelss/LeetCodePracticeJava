package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-23 15:42
 * @File : LinkedList7.java
 * @Description :链表-快慢指针-876. 链表的中间结点-2（解出，但没用快慢指针）
 * 总体思路1：1.计算节点数cnt2.取cnt中间值
 * 总体思路2：慢指针走一步，快指针走2步，到达结尾时，慢指针一定在中间
 */

public class LinkedList7 {
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

    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        for (int i = 0; i < Math.floor(cnt / 2); i++) {
            // System.out.println(head.val);
            head = head.next;
        }
        return head;
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
}
