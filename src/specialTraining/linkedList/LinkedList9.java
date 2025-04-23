package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-23 16:15
 * @File : LinkedList9.java
 * @Description :链表-快慢指针-142. 环形链表 II-2
 * 总体思路：计算公式
 * 1.a：head到入口举例；b：入口到fast和slow相遇距离；c相遇距离到入口距离
 * 2.相遇条件下：慢指针走的距离：a+b；快指针走的距离：a+b+k(b+c)
 * 3.移项后，a-c=(k-1)(b+c)：代表head和slow同时向入口走的距离相等，相遇时即为入口。
 */

public class LinkedList9 {
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

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head!=slow){
                    head=head.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
