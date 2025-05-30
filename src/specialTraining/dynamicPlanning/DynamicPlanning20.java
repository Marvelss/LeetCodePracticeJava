package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-30 9:25
 * @File : DynamicPlanning20.java
 * @Description :动态规划-树形DP-124. 二叉树中的最大路径和
 * 总体思路：所求答案=左子树的最大链和+右子树的最大链和+本身节点值
 * 递归返回的节点值：左右子树的最大链和+当前节点，（注意点这里若左右子树存在-1，则直接返回0，通过max（左右子树值，0）比较）
 *
 */

public class DynamicPlanning20 {
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

    private int ans = Integer.MIN_VALUE;

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + root.val);
        return Math.max(Math.max(left, right) + root.val, 0);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
}
