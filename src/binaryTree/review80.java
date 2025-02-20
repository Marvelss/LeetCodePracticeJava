package binaryTree;/*
 * @Author : Vagrant
 * @Time: 2025-02-20 21:14
 * @File : review80.java
 * @Description : 501. 二叉搜索树中的众数(思路对，代码没写出来)

 方法1：遍历两次，第一次统计最高频率，第二次频率==最高时，添加元素


 方法2：二叉树性质，进行两次判断
 step：为一个数频率
 maxStep：为最大频率
 tempList：最大频率对应的数字
 第一个判断条件：前值==后值？若true则step+1，否则step=1；
 第二个判断条件：判断step>max还是step=max；
 前者进行三步：更新maxStep，移除tempList所有元素，tempList添加当前值
 后者：tempList添加当前值

 注意点： ArrayList<Integer>转为int []
 */


import java.util.ArrayList;

public class review80 {
    public int maxStep;
    public int step;
    TreeNode pre;
    public ArrayList<Integer> resList = new ArrayList<>();

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

    public void traverse(TreeNode treeNode) {
        if (treeNode == null) return;
        traverse(treeNode.left);

        if (pre == null || pre.val != treeNode.val) {
            step = 1;
        } else {
            step += 1;
        }
        if (step > maxStep) {
            maxStep = step;
            resList.clear();
            resList.add(treeNode.val);
        } else if (step == maxStep) {
            resList.add(treeNode.val);
        }

        pre = treeNode;



        traverse(treeNode.right);
    }

    public int[] findMode(TreeNode root) {

//            获取递增数组
        maxStep = 0;
        step = 1;
        pre = null;
        resList = new ArrayList<>();
        traverse(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}

