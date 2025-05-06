package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Vagrant
 * @Time: 2025-05-06 9:42
 * @File : BinaryTree17.java
 * @Description :二叉树与递归-前序/中序/后序-105. 从前序与中序遍历序列构造二叉树-2
 * 总体思路：递归拼接节点
 * 1.递归函数，1.返回值：节点，2.输入参数：前序和中序数组
 * 2.终止条件：1前序数组为空，返回null2.前序数组长度为1，返回最后一个节点
 * 3.单层循环：
 * 3.1根据前序数组获取根节点（第一个元素）
 * 3.2利用该节点分割中序数组，得到左、右节点
 * 3.3分割前序数组，利用中序遍历的分割点（本质还是得到中序数组左节点的长度），得到左、右节点
 */

public class BinaryTree17 {
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

    private TreeNode traverse(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty())  return null;
        TreeNode root = new TreeNode(preorder.get(0));
        if (preorder.size() == 1) return root;

        int splitIndex = inorder.indexOf(root.val);

        List<Integer> leftInorder = inorder.subList(0, splitIndex);
        List<Integer> rightInorder = inorder.subList(splitIndex + 1, inorder.size());
        List<Integer> leftPreorder = preorder.subList(1, splitIndex + 1);
        List<Integer> rightPreorder = preorder.subList(splitIndex + 1, preorder.size());
        root.left = traverse(leftPreorder, leftInorder);
        root.right = traverse(rightPreorder, rightInorder);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder[0] == -1) return new TreeNode(-1);
        List<Integer> preorderList = Arrays.stream(preorder)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        List<Integer> inorderList = Arrays.stream(inorder)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        return traverse(preorderList, inorderList);

    }
}
