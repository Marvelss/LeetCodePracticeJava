package specialTraining.binaryTree;

import java.util.*;

/**
 * @Author : Vagrant
 * @Time: 2025-05-08 15:06
 * @File : BinaryTree25.java
 * @Description :二叉树与递归-BFS-103. 二叉树的锯齿形层序遍历-1
 * 总体思路1：基于基于102. 二叉树的层序遍历，使用一个变量来判断层数奇偶性质，从而知道从右到左遍历
 */

public class BinaryTree25 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        int isReverse = 0;
        stack.add(root);
        while (!stack.isEmpty()) {
            int len = stack.size();
            List<Integer> tempAns = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode topNode = stack.poll();
                tempAns.add(topNode.val);
                if (topNode.left != null) stack.add(topNode.left);
                if (topNode.right != null) stack.add(topNode.right);
            }
            if (isReverse % 2 != 0) Collections.reverse(tempAns);
            ans.add(tempAns);
            isReverse++;
        }
        return ans;
    }
}
