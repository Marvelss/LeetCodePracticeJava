package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-09 13:53
 * @File : BinaryTree30.java
 * @Description :二叉树与递归-117. 填充每个节点的下一个右侧节点指针 II-1
 *总体思路：同2641. 117. 填充每个节点的下一个右侧节点指针
 */

public class BinaryTree30 {
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

    public Node connect(Node root) {
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
}
