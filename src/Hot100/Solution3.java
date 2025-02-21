package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-21 21:50
 * @File : Review81.java
 * @Description : 543. 二叉树的直径（思路代码抄）

 思路：后序遍历
 1.TreeNode
 2.节点为空
 3.取左右节点个数+1，对比获取最大值maxLen = Math.max(maxLen, leftLen + rightLen + 1);
 注意：
 1.maxLen起始值=1
 2.遍历时，返回左右子数的最大值，且需要+1

 */

public class Solution3 {
    int maxLen;

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

    public int traverse(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int leftLen = traverse(treeNode.left);
        int rightLen = traverse(treeNode.right);
        maxLen = Math.max(maxLen, leftLen + rightLen + 1);
        return Math.max(leftLen, rightLen) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxLen = 1;
        traverse(root);
        return maxLen-1;
    }
}
