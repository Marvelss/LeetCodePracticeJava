package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-25 21:22
 * @File : Solution44.java
 * @Description : 337. 打家劫舍 III
 总体思路
 0.两个状态dp[0]代表不偷的最大金币，dp[1]偷最大金币
 1.int[] ropTree(TreeNode)
 2.cur==null return[0,0]
 3.后续遍历
 leftDp = ropTree(左边)
 rightDp = ropTree(右边)
 偷的情况:当前节点+leftDp[0]+rightDp[0]
 不偷情况:max(leftDp[0],leftDp[1])+max(rightDp[0],rightDp[1])
 */

import Offer71.SolutionOffer11;

public class Solution44 {
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

    private int[] robTree(TreeNode treeNode) {
        if (treeNode == null) return new int[]{0, 0};

        int[] leftDp = robTree(treeNode.left);
        int[] rightDp = robTree(treeNode.right);
        int rob = treeNode.val + leftDp[0] + rightDp[0];
        int noRob = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);
        return new int[]{noRob, rob};
    }

    public int rob(TreeNode root) {
        if (root==null)return 0;
        if (root.left==null &&root.right==null)return root.val;
        int []res = robTree(root);
        return Math.max(res[0],res[1]);
    }
}
