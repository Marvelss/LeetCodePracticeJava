package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-28 16:28
 * @File : BinaryTree2.java
 * @Description :二叉树与递归-深入理解-111. 二叉树的最小深度-3
 * 总体思路：基于104. 二叉树的最大深度，当节点为叶子时(左右子树为空)，才更新最小深度
 */

public class BinaryTree2 {
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

    int ans = Integer.MAX_VALUE;

    private void traverse(TreeNode root, int cnt) {
        if (root == null) return;
        cnt++;
        if (root.left == root.right) ans = Math.min(ans, cnt);
        traverse(root.left, cnt);
        traverse(root.right, cnt);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        traverse(root, 0);
        return ans;
    }
}
