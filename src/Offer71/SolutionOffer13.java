package Offer71;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-06-02 14:14
 * @File : Offer71.temp.java
 * @Description :LCR 153. 二叉树中和为目标值的路径
 * 卡点：回溯这一步操作不太明白，在左右递归结束后，再回溯，可以最后一个节点代入数字演练更形象理解
 */

public class SolutionOffer13 {
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

    private List<List<Integer>> ans = new ArrayList<>();

    private void traverse(TreeNode root, int sumT, List<Integer> path, int target) {
        if (root == null) return;
        path.add(root.val);
        sumT += root.val;
        if (sumT == target && root.left == null && root.right == null) ans.add(new ArrayList<>(path));

        // System.out.println(sumT);
        // System.out.println(target);
        // System.out.println(path.size());
        // System.out.println("------------");


        traverse(root.left, sumT, path, target);
        traverse(root.right, sumT, path, target);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        if (root == null) return new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(root, 0, path, target);
        return ans;
    }
}
