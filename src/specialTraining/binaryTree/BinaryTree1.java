package specialTraining.binaryTree;


/**
 * @Author : Vagrant
 * @Time: 2025-04-28 15:53
 * @File : BinaryTree1.java
 * @Description :二叉树与递归-深入理解-104. 二叉树的最大深度-2
 * 总体思路1：递归分治法
 * 返回左右子数的最大深度+1
 * 总体思路2：递归传参法
 * 用一个ans深度变量递归往下传，然后更新最大深度
 */

public class BinaryTree1 {
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
    int ans = 0;

    private void traverse(TreeNode root, int cnt) {
        if (root == null) return;
        cnt++;
        ans = Math.max(ans, cnt);
        traverse(root.left, cnt);
        traverse(root.right, cnt);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        traverse(root, 0);
        return ans;
    }
}
