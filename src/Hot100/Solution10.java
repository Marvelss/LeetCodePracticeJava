package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-25 20:29
 * @File : Solution10.java
 * @Description : 2. 两数相加
整体思路1（自己写时思路一致，但代码未调试AC，代码较多）：
补齐长度，元素相加，考虑进位
步骤
1.获取两个链表所对应的长度
2.在较短的链表末尾补零
3.对齐相加考虑进位

整体思路2：使用第三个节点，插入元素
注意点：
1.判断(l1 != null || l2 != null)
2.元素相加，考虑进位
3.最后一位为1时，插入新节点1

 */


public class Solution10 {
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

    public int getLen(ListNode cur1) {
        ListNode tempNode = cur1;
        int tempLen = 0;
        while (tempNode != null) {

            tempLen += 1;
            tempNode = tempNode.next;
        }
        return tempLen;
    }

    //    补齐
    public ListNode filledNode(ListNode cur1, int start, int len) {
        ListNode tempNode = cur1;
        for (int i = 0; i < start - 1; i++) {
            tempNode = tempNode.next;
        }
        for (int i = 0; i < len; i++) {
            tempNode.next = new ListNode(0);

        }
        return tempNode;
    }

    //        1.链表相加
    public ListNode addNum(ListNode cur1, ListNode cur2, int maxLen) {
        int count = 0;
        while (cur1 != null) {
            System.out.println(count);
            cur1.val = cur1.val + cur2.val;
            if (cur1.val > 10) {
                int reminder = cur1.val % 10;
                int single = cur1.val / 10;
                cur1.val = reminder;
                cur1.next.val += single;
            } else if (cur1.val == 10 && maxLen == count) {
                int reminder = cur1.val % 10;
                int single = cur1.val / 10;
                cur1.val = reminder;
                cur1.next = new ListNode(single);
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
            count += 1;
        }
        return cur1;
    }

    public ListNode reverse(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return cur;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseNode = null;

//        0.获取长度
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        if (len1 > len2) {
            //    补齐
            ListNode ll2 = filledNode(l2, len2, len1 - len2);

//        1.链表相加
            ListNode twoNum = addNum(l1, ll2, len1);
//        2.反转链表
            reverseNode = reverse(twoNum);

        } else {
            ListNode ll1 = filledNode(l1, len1, len2 - len1);
            ListNode twoNum = addNum(l2, ll1, len2);
            reverseNode = reverse(twoNum);
        }


        return reverseNode;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1!= null) l1 = l1.next;
            if (l2!= null) l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }


}
