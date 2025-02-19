package binaryTree;/*
 * @Author : Vagrant
 * @Time: 2025-02-19 18:13
 * @File : review79.java
 * @Description : 530. 二叉搜索树的最小绝对差

 思路：根据二叉搜索树中序遍历性质，二叉搜索树中序遍历的元素递增

 方式1：中序遍历二叉搜索树元素存入数组，再操作数组

 方式2：不放入数组，直接遍历时记录前一个值，比较前后值差取最小(与98. 验证二叉搜索树遍历类似)
 注意：在每次遍历中节点时，进行赋值pre=treeNode;，以记录上一个节点；

 */

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.ArrayList;
import java.util.List;

public class review79 {
    int res = Integer.MAX_VALUE;
    TreeNode pre = null;

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

    public void traverse1(TreeNode treeNode, List<Integer> nodeList) {
        if (treeNode == null) return;
        traverse1(treeNode.left, nodeList);
        nodeList.add(treeNode.val);
        traverse1(treeNode.right, nodeList);
    }

    public int getMinimumDifference1(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        int res = Integer.MAX_VALUE;
        traverse1(root, nodeList);
        for (int i = 0; i < nodeList.size() - 1; i++) {
            int temp = nodeList.get(i + 1) - nodeList.get(i);
            res = Math.min(temp, res);
        }
        return res;
    }


    public void traverse2(TreeNode treeNode) {
        if (treeNode == null) return;
        traverse2(treeNode.left);
        System.out.println(treeNode.val);
        System.out.println( pre.val);
        if (pre != null) {
            res = Math.min((treeNode.val - pre.val), res);
        }
        pre=treeNode;
    }

    public int getMinimumDifference2(TreeNode root) {
        traverse2(root);
        return res;
    }
}
