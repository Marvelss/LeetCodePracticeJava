package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-30 5:20
 * @File : BinaryTree10.java
 * @Description :二叉树与递归-灵活运用-226. 翻转二叉树-1
 * 总体思路：递归分治，递归左右节点，然后交互根节点的左右节点
 */

public class BinaryTree10 {
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


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;

        root.right = left;
        return root;
    }
}
