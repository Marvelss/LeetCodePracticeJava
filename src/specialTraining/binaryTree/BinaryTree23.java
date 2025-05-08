package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-08 10:02
 * @File : BinaryTree23.java
 * @Description :二叉树与递归-最近公共祖先-1123. 最深叶节点的最近公共祖先-2(抄了，感觉不太理解如何求解公共解的条件)
 * 总体思路：感觉主要基于深度遍历，当leftMaxDepth=rightMaxDepth=maxDepth即为题解
 */

public class BinaryTree23 {
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

    private TreeNode ans;
    private int maxDepth = -1; // 全局最大深度

    private int traverse(TreeNode root, int cnt) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, cnt);
            return cnt;
        }
        int left = traverse(root.left, cnt + 1);
        int right = traverse(root.right, cnt + 1);


        if (left == right && left == maxDepth) ans = root;
        return Math.max(left, right);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        traverse(root, 0);

        return ans;
    }
}
