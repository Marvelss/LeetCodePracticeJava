package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-09 15:45
 * @File : Solution63.java
 * @Description : 124. 二叉树中的最大路径和
 总体思路：遍历计算每个节点的最大路径和，取最大值
 1.ans作为全局变量，所以不作为递归参数
 2.节点为空，返回0；
 3.收集答案与返回上级节点
 3.1 ans=左+右节点最大路径+当前节点值，与ans比较取最大
 3.2比较左与右节点的路径，取最大路径值；注意再加一步，若总和<0，则不计该点
 */

public class Solution63 {
    private int ans = Integer.MIN_VALUE;

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


    private int traverse(TreeNode root) {
        if (root == null) return 0;
        int leftNode = traverse(root.left);
        int rightNode = traverse(root.right);

        ans = Math.max(leftNode + root.val + rightNode, ans);
        return Math.max(Math.max(leftNode, rightNode) + root.val, 0);
    }

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return ans;
    }
}
