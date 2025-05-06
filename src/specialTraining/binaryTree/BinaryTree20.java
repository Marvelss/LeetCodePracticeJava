package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author : Vagrant
 * @Time: 2025-05-06 14:40
 * @File : BinaryTree20.java
 * @Description :二叉树与递归-前序/中序/后序-1110. 删点成林-2(感觉不太理解，后序遍历可能还需进一步理解)
 * 与1080. 根到叶路径上的不足节点类似
 * 总体思路：后序遍历
 * 1.若当前元素为删除元素，则返回null；否则返回当前节点
 * 1.1若当前节点的左节点或右节点任意一个不为空，则添加答案
 * 1.2若都为空，则不添加进答案
 * 小技巧：利用HashSet查询将时间复杂度从O(N)降为O（1）
 */

public class BinaryTree20 {
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

    private TreeNode dfs(List<TreeNode> ans, Set<Integer> set, TreeNode root) {
        if (root == null) return null;
        root.left = dfs(ans, set, root.left);
        root.right = dfs(ans, set, root.right);
        if (!set.contains(root.val)) return root;
        if (root.left != null) ans.add(root.left);
        if (root.right != null) ans.add(root.right);
        return null;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        if (dfs(ans, set, root) != null) ans.add(root);
        return ans;
    }
}
