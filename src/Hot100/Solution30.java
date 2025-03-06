package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-06 21:07
 * @File : Solution30.java
 * @Description : 114. 二叉树展开为链表
 总体思路：不遍历，直接修建
 1.将根节点的两个左右两个节点看成一个整体
 2.右节点整体移除，接到左节点的右边最底层
 3.左节点移至右节点，并将左节点设为null
 */

public class Solution30 {
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


    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode nodeLeft = root.left;
                while (nodeLeft.right != null) nodeLeft = nodeLeft.right;
                nodeLeft.right=root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
