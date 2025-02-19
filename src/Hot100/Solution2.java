package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-19 18:58
 * @File : Solution2.java
 * @Description : 21. 合并两个有序链表(思路代码抄)

 思路：双指针法
 可参考LeetCode解析的动画：Krahets
未看懂有剩余节点部分： 如果有剩余节点，直接连接到新链表的末尾
 */

class Solution2 {
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode header = new ListNode(-1);
        ListNode current = header;
        while (list1!=null  && list2!=null){
            if (list1.val<list2.val){
                current.next=list1;
                list1=list1.next;
            }else {
                current.next=list2;
                list2=list2.next;
            }
            current = current.next;  // 移动当前指针
        }
        // 如果有剩余节点，直接连接到新链表的末尾
        if (list1!=null)current.next=list1;
        if (list2!=null)current.next=list2;
        return header.next;
    }
}