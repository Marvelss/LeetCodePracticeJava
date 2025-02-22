package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-22 19:53
 * @File : Solution5.java
 * @Description : 160. 相交链表

 思路1：平齐两个链表长度，长的链表先走几步
 思路2：双指针，分别同时从A,B开头移动A+B的长度
 注意：因为A+B长度一致，所以两个指针总长度一致，若有相交则中途即可退出；若无，则最后一定同时为null
 */

public class Solution5 {
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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA != null ? curA.next : curB;
            curB = curB != null ? curB.next : curA;
        }
        return curA;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;
//        计算两个列表长度差
        while (curA != null) {
            lenA += 1;
            curA = curA.next;
        }
        while (curB != null) {
            lenB += 1;
            curB = curB.next;
        }
//        平齐两个列表长度
        int difference = lenA - lenB;
        if (difference < 0) {
            while (difference != 0) {
                headB = headB.next;
                difference += 1;
            }
        } else {
            while (difference != 0) {
                headA = headA.next;
                difference -= 1;
            }
        }
//        判断是否香蕉
        while (headB != null) {
            if (headA == headB) return headB;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

}
