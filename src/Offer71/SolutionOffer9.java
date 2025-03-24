package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-24 20:24
 * @File : SolutionOffer9.java
 * @Description : LCR 151. 彩灯装饰记录 III
 总体思路：在 LCR 150. 彩灯装饰记录的基础上，添加isInvert层，用mod2取余数判断奇偶层
 */

import java.util.*;

public class SolutionOffer9 {
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

    public List<List<Integer>> decorateRecord(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int isInvert = 1;
        if (root == null) return ans;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tempAns = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode treeNode = queue.poll();
                tempAns.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            if (isInvert%2==1)ans.add(tempAns);

            else{
                Collections.reverse(tempAns);
                ans.add(tempAns);
            }
            isInvert++;
        }
        return ans;
    }
}
