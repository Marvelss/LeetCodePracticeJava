package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-25 9:41
 * @File : Solution10.java
 * @Description : LCR 145. 判断对称二叉树
 总体思路
 1.终止条件
 1.1左空右不空，返回F
 1.2左不空右空，返回F
 1.3左空右空，返回T
 1.5左不空右不空，值不相等，返回F
 2.单层循环（左不空右不空，值相等情况）
 2.1外侧遍历，内侧遍历，两者都为true时才对此

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionOffer10 {
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

    private boolean traverse(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode != null) return false;
        else if (leftNode != null && rightNode == null) return false;
        else if (leftNode == null && rightNode == null) return true;
        else if (leftNode != null && rightNode != null && leftNode.val != rightNode.val) return false;



        boolean left = traverse(leftNode.left, rightNode.right);
        boolean right = traverse(leftNode.right, rightNode.left);
        System.out.println(leftNode.val);
        System.out.println(rightNode.val);
        return left && right;

    }

    public boolean checkSymmetricTree(TreeNode root) {
        if (root==null)return true;
        return traverse(root.left, root.right);
    }
}
