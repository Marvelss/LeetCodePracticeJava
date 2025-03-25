package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-25 18:48
 * @File : SolutionOffer11.java
 * @Description : LCR 144. 翻转二叉树(想复杂了，不是用对称二叉树思路，先遍历外层再内层交换（这样交换不符合题规），而是直接遍历交互节点)
 总体思路：使用前序遍历，交互节点
 */

public class SolutionOffer11 {
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

    private void swap(TreeNode treeNode) {
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
    }

    public TreeNode flipTree(TreeNode root) {
        if (root == null) return null;

        swap(root);
        flipTree(root.left);
        flipTree(root.right);
        return root;
    }
}
