package specialTraining.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-08 15:12
 * @File : BinaryTree26.java
 * @Description :二叉树与递归-BFS-513. 找树左下角的值-1
 * 总体思路1：基于102. 二叉树的层序遍历，取该答案的最后一个数组的第一个元素
 * 总体思路2：不记录每层信息，直接得到最后答案，层序遍历从右往左记录（右节点先进），最后一个元素即为题解
 */

public class BinaryTree26 {
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

    public int findBottomLeftValue(TreeNode root) {
//        if (root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
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
            ans.add(tempAns);
        }
        return ans.get(ans.size() - 1).get(0);
    }

    public int findBottomLeftValue1(TreeNode root) {
//        if (root == null) return new ArrayList<>();
        int ans = root.val;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode topNode = stack.poll();
            ans = topNode.val;
            if (topNode.right != null) stack.add(topNode.right);
            if (topNode.left != null) stack.add(topNode.left);
        }
        return ans;
    }
}
