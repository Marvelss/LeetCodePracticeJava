package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-27 9:20
 * @File : Solution46.java
 * @Description : 297. 二叉树的序列化与反序列化
 总体思路：DFS
 1.序列化：使用前序遍历，注意空节点也保存
 2.反序列化：依次取字符串头元素，然后使用前序遍历顺序返回
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution46 {
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)  return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] nodes = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(nodes));
        return builderTree(queue);
    }
    // Decodes your encoded data to tree.
    public TreeNode builderTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("X"))return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left=builderTree(queue);
        root.right=builderTree(queue);
        return root;
    }
}
