package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-06 8:56
 * @File : BinaryTree16.java
 * @Description :二叉树与递归-前序/中序/后序-230. 二叉搜索树中第 K 小的元素-1
 * 总体思路1：中序遍历，使用数组记录元素获取递增数组，取第k个下标索引
 * 总体思路2：中序遍历，不使用数组记录元素，使用cnt记录下标，cnt==k-1时为符合题解
 */

public class BinaryTree16 {
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

    private int index = 0;
    private int ans;

    private void traverse(TreeNode root, int k) {
        if (root == null) return;

        traverse(root.left, k);
        if (index == k - 1) {
            ans = root.val;
            index++; //当子节点符合题解时，会返回返回父节点，index++避免再次进入该条件，将父节点误判为答案
            return;
        } else {
            index++;
        }
        traverse(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }
}
