package specialTraining.binaryTree;

import java.util.*;

/**
 * @Author : Vagrant
 * @Time: 2025-05-08 14:36
 * @File : BinaryTree24.java
 * @Description :二叉树与递归-BFS-102. 二叉树的层序遍历-1
 * 总体思路1：队列
 * 总体思路2：双数组
 */

public class BinaryTree24 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int len = stack.size();
            List<Integer> tempAns = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode topNode = stack.poll();
                tempAns.add(topNode.val);
                if (topNode.left != null) stack.add(topNode.left);
                if (topNode.right != null) stack.add(topNode.right);
            }
            ans.add(tempAns);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            int len = cur.size();
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> tempAns = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode topNode = cur.get(i);
                tempAns.add(topNode.val);
                if (topNode.left != null) nxt.add(topNode.left);
                if (topNode.right != null) nxt.add(topNode.right);
            }
            cur = nxt;
            ans.add(tempAns);
        }
        return ans;
    }
}
