package specialTraining.binaryTree;

/**
 * @Author : Vagrant
 * @Time: 2025-04-30 13:22
 * @File : BinaryTree13.java
 * @Description :二叉树与递归-灵活运用-1026. 节点与其祖先之间的最大差值-2
 * 总体思路：同1448. 统计二叉树中好节点的数目，该题简化为求一条路径下的一个节点与其他节点的最大差值
 * 最大差值=节点1-节点2，当节点1最大，节点2最小时，差值最大，所以目标转为找最大小节点
 */

public class BinaryTree13 {


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

    private int ans;

    private void traverse(TreeNode root, int minNum, int maxNum) {
        if (root == null) return;
        minNum = Math.min(minNum, root.val);
        maxNum = Math.max(maxNum, root.val);
        ans = Math.max(Math.abs(maxNum - minNum), ans);
        traverse(root.left,minNum,maxNum);
        traverse(root.right,minNum,maxNum);
    }

    public int maxAncestorDiff(TreeNode root) {
        traverse(root, root.val, root.val);
        return ans;
    }
}
