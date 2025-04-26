package specialTraining.linkedList;

/**
 * @Author : Vagrant
 * @Time: 2025-04-26 21:05
 * @File : LinkedList15.java
 * @Description :链表-删除指针-237. 删除链表中的节点-2
 * 总体思路：很像删除数组，当前元素直接复制下一个元素:arr[i]=arr[i+1]，只不过链表中的替换元素用各自方法
 */

public class LinkedList15 {
    static class ListNode {
        int val;
        LinkedList14.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, LinkedList14.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }
}
