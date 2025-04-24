package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-24 14:43
 * @File : LinkedList12.java
 * @Description :链表-删除指针-83. 删除排序链表中的重复元素-1
 * 总体思路1：使用cur=pre.next进行对比，while (pre.val == cur.val) 时，删除节点，并一直移动cur
 * 总体思路2（更简洁）：不额外赋值cur
 * 对比上述两种思路，感觉思路1是以上个节点为基准，与当前节点作比较；思路2以当前节点为基准，与下个节点做比较
 * 进一步，这种链表的遍历方式与数组又类似，思路1：for(i=1,i<n,i++)arr[i-1]==arr[i]；思路2：for(i=0,i<n,i++)arr[i]==arr[i+1]
 */

public class LinkedList12 {
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

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode pre = head;
        while (pre != null && pre.next != null) {
            ListNode cur = pre.next;
            System.out.println(pre.val);
            while (pre.val == cur.val) {
                if (cur.next != null) {
                    pre.next = cur.next;
                    cur = pre.next;
                } else {
                    pre.next = null;
                    return head;
                }

            }
            pre = cur;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else cur = cur.next;
        }
        return head;
    }
}
