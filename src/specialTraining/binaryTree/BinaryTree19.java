package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Vagrant
 * @Time: 2025-05-06 14:14
 * @File : BinaryTree19.java
 * @Description :二叉树与递归-前序/中序/后序-889. 根据前序和后序遍历构造二叉树-3
 * 总体思路：基于106. 从中序与后序遍历序列构造二叉树
 * 卡点在于：由于该题意含多种情况，无法确认左右子树的切割点，所以需要假设默认情况，默认前序数组的第2个元素为左子树，并作为切割点
 * 注意点：leftPostorder、rightPostorder、leftPreorder、rightPreorder切割时的边界点
 * 如leftPostorder时，右边区间应为splitIndex + 1；rightPostorder右区间为postorder.size()，不包含最后一个元素，因为它时是根节点；
 * leftPreorder的右区间应为leftPostorder.size() + 1
 */

public class BinaryTree19 {
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

    private TreeNode traverse(List<Integer> preorder, List<Integer> postorder) {
        if (preorder.isEmpty()) return null;
        TreeNode root = new TreeNode(preorder.get(0));
        if (preorder.size() == 1) return root;

        int splitIndex = postorder.indexOf(preorder.get(1));
//        System.out.println("后序-左-分割元素：" + preorder.get(1));
        List<Integer> leftPostorder = postorder.subList(0, splitIndex + 1); //注意这里splitIndex + 1表示包含切割点
//        System.out.println("后序-左-最后一个元素：" + leftPostorder.get(leftPostorder.size() - 1));
        List<Integer> rightPostorder = postorder.subList(splitIndex + 1, postorder.size());
        List<Integer> leftPreorder = preorder.subList(1, leftPostorder.size() + 1);
        List<Integer> rightPreorder = preorder.subList(leftPostorder.size() + 1, preorder.size());
        root.left = traverse(leftPreorder, leftPostorder);
        root.right = traverse(rightPreorder, rightPostorder);
        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        if (preorder[0] == -1) return new TreeNode(-1);
        List<Integer> preorderList = Arrays.stream(preorder)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        List<Integer> postorderList = Arrays.stream(postorder)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        return traverse(preorderList, postorderList);

    }
}
