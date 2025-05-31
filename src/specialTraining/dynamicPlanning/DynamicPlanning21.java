package specialTraining.dynamicPlanning;

/**
 * @Author : Vagrant
 * @Time: 2025-05-31 18:14
 * @File : DynamicPlanning21.java
 * @Description :动态规划-树形DP-最大独立集-337. 打家劫舍 III
 * 卡点：遍历二叉树时，如何传递偷的状态，或者说，若当前节点偷了，怎么告诉子节点不能偷
 * 参考线性数组，若当前节点偷，则从上上个父节点状态转移，所以需要考虑儿子的儿子的节点，
 * 为此需要改版，增加传递两种状态，从而只需考虑父节点和左右节点即可
 * 解决：当遍历单次二叉树时，自然能够获取父节点与左右孩子状态，只需要计算结果即可
 */

public class DynamicPlanning21 {
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
        if (root == null) return new int[]{0, 0};
        int[] left = robTemp(root.left);
        int[] right = robTemp(root.right);
        int rob = left[1] + right[1] + root.val;
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, notRob};
    }

    public int rob(TreeNode root) {
        int[] ans = robTemp(root);
        return Math.max(ans[0], ans[1]);
    }
}
