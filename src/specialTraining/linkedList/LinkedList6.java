package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-22 16:07
 * @File : LinkedList6.java
 * @Description :链表-反转链表-2816. 翻倍以链表形式表示的数字-1
 * 总体思路：与反转链表-445. 两数相加 II类似
 * 关键点：相加改为乘法，其他不变
 */

public class LinkedList6 {
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

    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode reverseList = reverseList(head);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (reverseList != null) {
            int multi = carry;
            multi += reverseList.val * 2;
            reverseList = reverseList.next;

            cur.next = new ListNode(multi % 10);
            cur = cur.next;
            carry = multi / 10;
//            System.out.println("cur:" + cur.val);
//            System.out.println(carry);
//            System.out.println("-----------");
        }
        if (carry != 0) {
            cur.next = new ListNode(1);
        }

        return reverseList(dummy.next);
    }
}
