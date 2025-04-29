package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-29 9:47
 * @File : BinaryTree7.java
 * @Description :二叉树与递归-灵活运用-101. 对称二叉树-2
 * 总体思路：基于100. 相同的树，由于题目要求是对称，所以需要修改相等条件，应判断外侧的节点相等+内侧节点相等
 */

public class BinaryTree7 {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }
}
