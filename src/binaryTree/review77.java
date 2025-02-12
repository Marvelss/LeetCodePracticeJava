package binaryTree;/*
 * @Author : Vagrant
 * @Time: 2025-02-12 16:23
 * @File : review77.java
 * @Description : 700. 二叉搜索树中的搜索
 1.节点、目标值
 2.节点为空
 3.节点值==目标值，则返回；节点值>目标值，遍历左节点；否则遍历右节点

 */

import javax.swing.tree.TreeNode;

class review77 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        System.out.println(root.val);
        System.out.println(val);
        System.out.println("==========");
        if (root.val == val) {
            return root;
        }
        if (root.val<val) {
            return searchBST(root.right,val);
        }else {
            return searchBST(root.left,val);
        }
    }
}

