package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-30 7:09
 * @File : BinaryTree12.java
 * @Description :二叉树与递归-灵活运用-1080. 根到叶路径上的不足节点-2（感觉题干不太清晰，不容易理解）
 * 总体思路：题目转换的条件如下：
 * 叶子节点和非叶子节点，删除的条件情况：
 * 叶子节点是：整个路径的limit不满足，则删除；
 * 非叶子节点是：原有的子节点如果都被删除，则删除；
 */

public class BinaryTree12 {
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

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        if (root.left == root.right) return root.val < limit ? null : root;
        if (root.left != null) root.left = sufficientSubset(root.left, limit - root.val);
        if (root.right != null) root.right = sufficientSubset(root.right, limit - root.val);
        return root.left == null && root.right == null ? null : root;
    }
}
