package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Vagrant
 * @Time: 2025-05-06 10:18
 * @File : BinaryTree18.java
 * @Description :二叉树与递归-前序/中序/后序-106. 从中序与后序遍历序列构造二叉树-3
 * 总体思路：基于105. 从前序与中序遍历序列构造二叉树
 * 关键点：与105题不同之处在于后序节点的左右节点如何分割（利用中序遍历左节点的长度，获得左节点）
 * 注意点：考虑两个边界值：1.若poster为空则返回null，若长度==1，可直接返回rootNode
 */

public class BinaryTree18 {
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

    private TreeNode traverse(List<Integer> postorder, List<Integer> inorder) {
        if (postorder.isEmpty()) return null;

        TreeNode rootNode = new TreeNode(postorder.get(postorder.size() - 1));

        if (postorder.size() == 1) return rootNode;
        int splitIndex = inorder.indexOf(rootNode.val);

        List<Integer> leftInorder = inorder.subList(0, splitIndex);
        List<Integer> rightInorder = inorder.subList(splitIndex + 1, inorder.size());
        List<Integer> leftPostorder = postorder.subList(0, leftInorder.size()); //后序节点的左右节点如何分割，根据中序遍历左节点的长度，获得左节点
        List<Integer> rightPostorder = postorder.subList(leftInorder.size(), postorder.size() - 1);
        rootNode.left = traverse(leftPostorder, leftInorder);
        rootNode.right = traverse(rightPostorder, rightInorder);
        return rootNode;


    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder[0] == -1) return new TreeNode(-1);
        List<Integer> postorderList = Arrays.stream(postorder)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        List<Integer> inorderList = Arrays.stream(inorder)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        return traverse(postorderList, inorderList);

    }
}
