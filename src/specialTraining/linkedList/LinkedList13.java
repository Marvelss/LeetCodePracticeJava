package specialTraining.linkedList;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author : Vagrant
 * @Time: 2025-04-26 19:04
 * @File : LinkedList13.java
 * @Description :链表-删除指针-82. 删除排序链表中的重复元素 II-2
 * 卡在1.循环删除节点不太明确2.cur与dummy的关系：cur作为引用指针一直动；dummy作为虚拟节点不动，与head类似
 * 对应解决点：int val = cur.next.val;（关键）用当前节点一直和删除后的节点作比较，从而不保留重复节点
 */

public class LinkedList13 {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val) {
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
