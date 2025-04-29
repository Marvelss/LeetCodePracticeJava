package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-29 10:10
 * @File : BinaryTree8.java
 * @Description :二叉树与递归-灵活运用-110. 平衡二叉树-2
 * 总体思路2：1.计算高度2.判断高度差是否>1：若大于则返回-1；否则继续计算高度
 *     private int recur(TreeNode root) {
 *         if (root == null) return 0;
 *         int left = recur(root.left);
 *         if (left == -1) return -1;
 *         int right = recur(root.right);
 *         if (right == -1) return -1;
 *         return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
 *     }
 * 总体思路1（巧妙些）：1.计算高度2.判断高度差是否>1；
 * 小技巧：可以将判断高度差是否>1转为数字-1，来标记是否符合题意；
 * 注意点：这题高度等同于深度
 */

public class BinaryTree8 {
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

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        if (left == -1) return -1;
        int right = getHeight(root.right);
        if (right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return (getHeight(root) != -1);
    }
}
