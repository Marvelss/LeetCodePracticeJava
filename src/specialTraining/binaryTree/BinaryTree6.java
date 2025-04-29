package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-29 8:51
 * @File : BinaryTree6.java
 * @Description :二叉树与递归-灵活运用-100. 相同的树-1
 * 总体思路：判断前序遍历判断节点是否相同
 */

public class BinaryTree6 {
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
}
