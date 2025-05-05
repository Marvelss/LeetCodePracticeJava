package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-04 9:46
 * @File : BinaryTree15.java
 * @Description :二叉树与递归-前序/中序/后序-938. 二叉搜索树的范围和
 * 总体思路1：通用方法，未用到二叉树性质：找到符合区间内的值，相加
 * 总体思路2：利用二叉树性质,前序遍历，中节点知道后，可以通过区间判断下一步走左or右子树
 */

public class BinaryTree15 {
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

    private int ans = 0;

    private void traverse(TreeNode root, int left, int right) {
        if (root == null) return;
        traverse(root.left, left, right);
        if (root.val >= left && root.val <= right) ans += root.val;
        traverse(root.right, left, right);
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return ans;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val <= high && root.val >= low) ans += root.val;
        if (root.val > low) ans += rangeSumBST2(root.left, low, high);
        if (root.val < high) ans += rangeSumBST2(root.right, low, high);
        return ans;
    }
}
