package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-24 19:20
 * @File : Solution7.java
 * @Description : LCR 149. 彩灯装饰记录 I
 总体思路：二叉树层序遍历
 */


import java.util.*;

public class SolutionOffer7 {
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

    public int[] decorateRecord(TreeNode root) {
        if (root == null) return new int[0];
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            ans.add(treeNode.val);
            if (treeNode.left != null) stack.add(treeNode.left);
            if (treeNode.right != null) stack.add(treeNode.right);
        }
        int[] ans2 = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ans2[i] = ans.get(i);
        }
        return ans2;
    }
}
