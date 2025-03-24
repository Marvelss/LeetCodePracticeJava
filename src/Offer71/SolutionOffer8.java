package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-24 19:37
 * @File : Solution8.java
 * @Description : LCR 150. 彩灯装饰记录 II(卡了下)
 卡点：如何把单层节点放入一个数组
 解决：for (int i = 0; i < queue.size(); i++)
 注意：queue是FIFO，所有遍历从一元素时应倒序  for(int i = queue.size(); i > 0; i--)
 */

import java.util.*;

public class SolutionOffer8 {
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
        if (root == null) return ans;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tempAns = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode treeNode = queue.poll();
                tempAns.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            ans.add(tempAns);
        }
        return ans;
    }
}
