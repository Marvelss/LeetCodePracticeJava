package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-05-08 9:20
 * @File : BinaryTree21.java
 * @Description :二叉树与递归-最近公共祖先-236. 二叉树的最近公共祖先-2
 * 总体思路：
 * 1.当前节点为空节点，返回当前节点（最终条件）
 * 2.当前节点==p，返回当前节点（最终条件）
 * 3.当前节点为q，返回当前节点（最终条件）
 * 4.其他（单层循环）
 * 4.1p和q分别在左右子树上，返回当前节点
 * 4.2p或q只在左子树找到，返回左子树
 * 4.3p或q只在右子树找到，返回右子树
 * 4.4都没找到，返回空节点
 */

public class BinaryTree21 {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}
