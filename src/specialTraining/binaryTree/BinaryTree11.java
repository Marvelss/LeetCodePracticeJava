package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-30 5:29
 * @File : BinaryTree11.java
 * @Description :二叉树与递归-灵活运用-617. 合并二叉树-1
 * 总体思路：递归分治
 * 1.终止情况分情况讨论：1.root1和root2都为空，返回null；2.root1为空，返回root2；3.root2为空，返回root1；
 * 2.单层循环，root1和root2的节点相加
 */

public class BinaryTree11 {
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        else if (root1 == null) return root2;
        else if (root2 == null) return root1;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        root1.val += root2.val;
        return root1;
    }
}
