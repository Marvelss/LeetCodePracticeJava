package specialTraining.dynamicPlanning;


import javax.swing.tree.TreeNode;

/**
 * @Author : Vagrant
 * @Time: 2025-05-30 9:07
 * @File : DynamicPlanning19.java
 * @Description :动态规划-树形DP-直径系列-543. 二叉树的直径-2
 * 所求答案：左子数最长链+右节点最长链+2
 * 递归返回值：根节点的直径=左节点最长链+右节点最长链+1（当前节点）
 * 注意，终止条件返回-1，使得左子树最长链和子树链接根节点的两条链值为0
 */

public class DynamicPlanning19 {
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

    private int ans;


    private int dfs(TreeNode root) {
        if (root == null) return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + 2);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
}
