package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-29 7:58
 * @File : BinaryTree5.java
 * @Description :二叉树与递归-深入理解-1448. 统计二叉树中好节点的数目-3
 * 总体思路1：基于129. 求根节点到叶节点数字之和，针对路径进一步处理，判断是否存在路径每个值<当前值
 * 总体思路2：不需要路径每个元素都判断，只判断当前整个路径的最大值是否<当前值
 */

public class BinaryTree5 {
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

    private int cnt = 0;
    private void traverse(TreeNode root,int maxNum) {
        if (root == null) return;
        if (maxNum <= root.val) cnt++;
        maxNum = Math.max(maxNum, root.val);
        traverse(root.left,maxNum);
        traverse(root.right,maxNum);
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        traverse(root, Integer.MIN_VALUE);
        return cnt;
    }
}
