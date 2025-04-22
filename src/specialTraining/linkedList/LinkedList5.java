package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-22 13:55
 * @File : LinkedList5.java
 * @Description :链表-反转链表-445. 两数相加 II-2
 * 总体思路：
 * 1.正序相加（不可行，步骤多，且无法处理当前值相加超过10，且前n个两数相加也超过10，一直循环情况情况）
 * 2.逆序相加
 * 关键点：1.使用carry进位，2.记录sum值3.使用dummy作为ans，相加两个节点记录答案
 */

public class LinkedList5 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) return l2;
        if (l2.val == 0) return l1;
        // 反转两个链表
        ListNode reversedL1 = reverseList(l1);
        ListNode reversedL2 = reverseList(l2);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (reversedL1 != null || reversedL2 != null || carry != 0) {
            int sum = carry;
            if (reversedL1 != null) {
                sum += reversedL1.val;
                reversedL1 = reversedL1.next;
            }
            if (reversedL2 != null) {
                sum += reversedL2.val;
                reversedL2 = reversedL2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;

        }
//        再翻转下
        return reverseList(dummy.next);
    }
}
