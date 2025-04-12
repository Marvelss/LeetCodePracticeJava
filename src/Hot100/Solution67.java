package Hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Vagrant
 * @Time: 2025-04-12 10:17
 * @File : Solution67.java
 * @Description :437. 路径总和 III
 * 总体思路：前缀和求和
 * 关键点：题解不仅求从根节点开始的路径总和，还包含子节点
 */

public class Solution67 {
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

    private int cnt = 0;
    Map<Long, Integer> map = new HashMap<>();

    private void findPath(TreeNode node, int targetSum, Long currentSum) {
        if (node == null) return;
        currentSum += node.val;

        if (map.containsKey(currentSum - targetSum)) cnt += map.get(currentSum - targetSum);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        findPath(node.left, targetSum, currentSum);
        findPath(node.right, targetSum, currentSum);
        map.put(currentSum, map.get(currentSum) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        findPath(root, targetSum, 0L);
        return cnt;
    }
}
