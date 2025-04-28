package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-28 19:38
 * @File : BinaryTree3.java
 * @Description :二叉树与递归-深入理解-112. 路径总和-1
 * 总体思路：基于111. 二叉树的最小深度，将条件改为路径总和是否为题解
 * 方式1：使用flag变量保存，看遍历的过程中是否存在题解
 * 方式2：如hasPathSum1，不使用flag变量，直接在最终顶层根节点判断过程中是否存在题解
 */

public class BinaryTree3 {
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

    private boolean flag = false;

    private void traverse(TreeNode root, int cnt, int target) {
        if (root == null) return;
        cnt += root.val;
        if (root.left == root.right && cnt == target) {
            flag = true;
            return;
        }
        traverse(root.left, cnt, target);
        traverse(root.right, cnt, target);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        traverse(root, 0, targetSum);
        return flag;
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == root.right) return targetSum == 0;
        return hasPathSum1(root.left, targetSum) || hasPathSum1(root.right, targetSum);
    }

}
