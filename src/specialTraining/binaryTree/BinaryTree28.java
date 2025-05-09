package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-09 13:29
 * @File : BinaryTree28.java
 * @Description :二叉树与递归-BFS-2415. 反转二叉树的奇数层-1
 * 总体思路：与103. 二叉树的锯齿形层序遍历类似，差别在于交互节点值，而不是节点
 */

public class BinaryTree28 {
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

    private void reverseList(List<TreeNode> nodes) {
        int i = 0;
        int j = nodes.size() - 1;
        while (i < j) {
            int temp = nodes.get(i).val;
            nodes.get(i).val = nodes.get(j).val;
            nodes.get(j).val = temp;
            i++;
            j--;
        }
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> cur = new ArrayList<>();
        int isReverse = 1;

        cur.add(root);
        while (!cur.isEmpty()) {
            int len = cur.size();
            List<TreeNode> nxt = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode topNode = cur.get(i);
                if (topNode.left != null) nxt.add(topNode.left);
                if (topNode.right != null) nxt.add(topNode.right);
            }
            if (isReverse % 2 != 0) reverseList(nxt);
            cur = nxt;
            isReverse++;
        }
        return root;
    }
}
