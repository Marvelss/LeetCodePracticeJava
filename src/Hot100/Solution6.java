package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-22 20:42
 * @File : Solution6.java
 * @Description : 234. 回文链表(抄)

 思路：1.找到中间节点 2.反转链表 3.比对
 1.找到中间节点，思路：快慢指针，slow走一步，fast走2步，所以fast走的步数是slow的2倍
 当fast或fast.next为空时，slow即为总长度的一半，即中间节点
 2.翻转链表,1.住pre，cur，curNext的指向，2.动三步，移动pre和cur指针，反转cur的链表指向


 */

public class Solution6 {
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


    public boolean isPalindrome(ListNode head) {
//        比对
        ListNode cur = head;
        ListNode mid = findMiddle(head);
        ListNode headFront = reverse(mid);
        while (headFront!=null){
            if(cur.val!=headFront.val)return false;
            cur = cur.next;
            headFront=headFront.next;
        }
        return true;
    }

    //        找到中间节点
    public ListNode findMiddle(ListNode listNode) {
        ListNode slow = listNode, fast = listNode;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //        遍历反转节点
    public ListNode reverse(ListNode listNode) {
        ListNode pre = null;
        while (listNode != null) {
            ListNode temp = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = temp;
        }
        return listNode;
    }

}
