package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-05-08 9:25
 * @File : BinaryTree22.java
 * @Description :二叉树与递归-最近公共祖先-235. 二叉搜索树的最近公共祖先-2
 * 总体思路：基于236. 二叉树的最近公共祖先进一步利用二叉搜索树性质优化
 * 1.当节点为空时，返回当前节点（可以不用写，终止条件）
 * 2.若p和q都小于当前节点，返回左子树
 * 3.若p和q都大于当前节点，返回右子树
 * 4.其他
 * 4.1p和q分别在左右子树上，返回当前节点
 * 4.2p或q为当前节点，返回当前节点
 * 4.3p或q为当前节点，返回当前节点
 */

public class BinaryTree22 {
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
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
