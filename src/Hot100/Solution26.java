package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-05 15:27
 * @File : Solution26.java
 * @Description :23. 合并 K 个升序链表
 总体思路：最小堆的应用
 将输入的头节点放入最小堆，依次弹出最小元素
 */

import java.util.PriorityQueue;

public class Solution26 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
