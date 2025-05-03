package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-05-03 10:17
 * @File : BinaryTree14.java
 * @Description :二叉树与递归-前序/中序/后序-98. 验证二叉搜索树-2
 * 总体思路1：先序遍历（符合题意的区间递归往下传）
 * 传入两个区间值，中：判断当前值是否在符合题意区间，递归左右节点，并用当前值作为区间分别传入
 * 总体思路2：中序遍历（判断是否递增数组）
 * 需要一个pre节点，然后左：传入节点；中：判断当前节点与pre节点大小，右递归
 * 总体思路3：后序遍历（符合题意的区间递归往下传）
 * 递归函数返回两个值：左右区间的值，然后递归左右节点，再判断当前值是否题意区间
 */

public class BinaryTree14 {
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

    private long pre = Integer.MIN_VALUE;

    //============================前序遍历============================
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        return traverse1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean traverse1(TreeNode root, long left, long right) {
        if (root == null) return true;
        long x = root.val;
        // 一般情况
        return x > left && x < right && traverse1(root.left, left, x) && traverse1(root.right, x, right);
    }

    //============================中序遍历============================
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST2(root.left)) return false;
        long x = root.val;
        if (x <= pre) return false;
        pre = x;
        return isValidBST2(root.right);
    }

    //============================后序遍历============================


    private long[] traverse3(TreeNode root) {
        if (root == null) return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        long[] leftMinMax = traverse3(root.left);
        long[] rightMinMax = traverse3(root.right);
        long x = root.val;
        if (x <= leftMinMax[1] || x >= rightMinMax[0]) return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        return new long[]{Math.min(leftMinMax[0], x), Math.max(rightMinMax[1], x)};

    }

    public boolean isValidBST3(TreeNode root) {
        return traverse3(root)[1]!=Long.MAX_VALUE;
    }
}
