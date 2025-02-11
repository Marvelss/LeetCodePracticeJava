package binaryTree;
/*
 * @Author : Vagrant
 * @Time: 2025-02-11 17:17
 * @File : review76.java
 * @Description : 654. 最大二叉树（终止条件未考虑到）
 * 未考虑到点：如果树1左节点不存在，直接返回树2的左节点；如果树2左节点不存在，直接返回树1的左节点；剩余情况就是树1，树2都存在情况，则相加
 * 思路1：直接将tree2加在tree1，而不是创建新tree
 * 思路2：创建一个新tree
 * TreeNode root = new TreeNode(root1.val + root2.val);
 * root.left = = mergeTrees(root1.left, root2.left);
 * root.right = mergeTrees(root1.right, root2.right);
 */

class TreeNode {
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

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if ( root2 == null) {
            return root1;
        }
        root1.val+=root2.val;
        root1.left=mergeTrees(root1.left,root2.left);
        root1.right=mergeTrees(root1.right,root2.right);
        return root1;
    }
}
