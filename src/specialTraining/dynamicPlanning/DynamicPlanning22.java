package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-31 19:09
 * @File : DynamicPlanning22.java
 * @Description :动态规划-树形DP-最小支配集-968. 监控二叉树
 * 主要分类3种情况：安装摄像头、不安装摄像头，但父节点安装摄像头、不安装摄像头，但左右孩子节点安装摄像头
 */

public class DynamicPlanning22 {
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

    private int[] robTemp(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE/2, 0, 0};
        int[] left = robTemp(root.left);
        int[] right = robTemp(root.right);
//        蓝色:安装摄像头
        int rob = Math.min(Math.min(left[0], left[1]), left[2]) + Math.min(Math.min(right[0], right[1]), right[2]) + 1;
//        黄色:不安装摄像头，但父节点安装摄像头
        int notRob1Left = Math.min(left[0], left[2]);
        int notRob1Right = Math.min(right[0], right[2]);
        int notRob1 = notRob1Left + notRob1Right;
//        红色:不安装摄像头，但左右孩子节点安装摄像头
        int notRob21 = left[0] + right[2];
        int notRob22 = left[2] + right[0];
        int notRob23 = left[0] + right[0];
        int notRob2 = Math.min(Math.min(notRob21, notRob22), notRob23);
        return new int[]{rob, notRob1, notRob2};
    }

    public int minCameraCover(TreeNode root) {
        int[] ans = robTemp(root);
        return Math.min(ans[0], ans[2]);
    }
}
