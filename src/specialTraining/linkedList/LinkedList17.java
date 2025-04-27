package specialTraining.linkedList;

import java.util.HashSet;

/**
 * @Author : Vagrant
 * @Time: 2025-04-27 9:00
 * @File : LinkedList17.java
 * @Description :链表-删除指针-3217. 从链表中移除在数组中存在的节点-2
 * 总体思路：通过一个HashSet来存储删除值，来降低暴力解法的时间复杂度
 */

public class LinkedList17 {
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

    public ListNode removeElements(ListNode head, HashSet<Integer> val) {
        System.out.println("val:" + val);
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (val.contains(cur.next.val)) cur.next = cur.next.next;
            else cur = cur.next;
        }
        System.out.println(dummy.next.val);
        return dummy.next;
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) {
            map.add(num);
        }
        return removeElements(head, map);
    }
}
