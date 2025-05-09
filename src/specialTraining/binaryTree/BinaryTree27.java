package specialTraining.binaryTree;

import java.util.*;

/**
 * @Author : Vagrant
 * @Time: 2025-05-09 13:26
 * @File : BinaryTree27.java
 * @Description :二叉树与递归-BFS-107. 二叉树的层序遍历 II-1
 * 总体思路1：基于BFS-102. 二叉树的层序遍历，翻转最后的结果
 */

public class BinaryTree27 {
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
    
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
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
        Collections.reverse(ans);
        return ans;
    }
}
