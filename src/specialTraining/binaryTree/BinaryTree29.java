package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-09 13:41
 * @File : BinaryTree29.java
 * @Description :二叉树与递归-BFS-116. 填充每个节点的下一个右侧节点指针-（总体思路-1+总体思路2-2）
 * 总体思路1：BFS，基于102. 二叉树的层序遍历，双数组法，遍历获得当前层，依次链接
 * 总体思路2：BFS+链表
 * 1.从第一层第一个依次遍历
 * 2.遍历当前层的节点，通过left和right获取下一层节点
 * 3.吧下一层节点链接
 * 4.拿到下一层的头节点，循环该流程
 */

public class BinaryTree29 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect1(Node root) {
        if (root == null) return null;
        List<Node> cur = new ArrayList<>();
        cur.add(root);
        root.next = null;
        while (!cur.isEmpty()) {
            int len = cur.size();
            List<Node> nxt = new ArrayList<>();
            for (int i = 0; i < len; i++) {
//                链接
                if (i == len - 1) cur.get(i).next = null;  //如果是最后一个指向null
                else cur.get(i).next = cur.get(i + 1);     //否则指向下一个节点
                Node topNode = cur.get(i);
                if (topNode.left != null) nxt.add(topNode.left);
                if (topNode.right != null) nxt.add(topNode.right);
            }
            cur = nxt;
        }
        return root;
    }

    public Node connect2(Node root) {
        Node dummy = new Node();  //虚拟头节点
        Node cur = root;
        while (cur != null) {
            dummy.next = null;
            Node nxt = dummy;   //下一层节点
            while (cur != null) {
                if (cur.left != null) {
                    nxt.next = cur.left;
                    nxt = cur.left;   //移动指针
                }
                if (cur.right != null) {
                    nxt.next = cur.right;
                    nxt = cur.right;
                }
                cur = cur.next;    //当前层移动到下个节点
            }
            cur = dummy.next;  // 移动到下一层链表的头节点
        }
        return root;
    }
}
