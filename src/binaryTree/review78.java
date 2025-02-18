package binaryTree;/*
 * @Author : Vagrant
 * @Time: 2025-02-18 19:42
 * @File : review78.java
 * @Description : 98. 验证二叉搜索树(思路抄)

陷阱1：只判断当前节点的左右子树是否左<中<右，无法解决该测试用例 [5,4,6,null,null,3,7]
解决方法：总体思路2，取到最左面节点的数值来比较，防止该情况

 总体思路1：使用中序遍历二叉树，若元素递增则为而有效的搜索二叉树
 1.节点
 2.节点为空
 3.左中右遍历，放入中节点

 总体思路2：使用中序遍历二叉树，对中节点进一步处理，取到最左面节点的数值来比较
 1.节点
 2.节点为空
 3.左中右遍历，使用pre记录前一个左节点值，中节点不为空，且前一个左节点值大于中节点，
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class review78 {
    TreeNode pre = null;

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
// 无法解决该测试用例 [5,4,6,null,null,3,7]
    public void traverse1(TreeNode treeNode, List<Integer> isSearchList) {
        if (treeNode == null) return;
        if (treeNode.left != null && treeNode.left.val >= treeNode.val) isSearchList.add(1);
        if (treeNode.right != null && treeNode.right.val <= treeNode.val) isSearchList.add(1);
        traverse1(treeNode.left, isSearchList);
        traverse1(treeNode.right, isSearchList);
    }
//    总体思路1
    public void traverse(TreeNode treeNode, List<Integer> isSearchList) {
        if (treeNode == null) return;
        traverse(treeNode.left, isSearchList);
        isSearchList.add(treeNode.val);
        traverse(treeNode.right, isSearchList);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer>  isSearchList = new ArrayList<>();
        traverse(root,isSearchList);
        for (int i = 0; i <isSearchList.size() -1; i++) {
            if(isSearchList.get(i)>=isSearchList.get(i+1)) return false;
        }
        return true;
    }

//    总体思路2

    public boolean isValidBST2(TreeNode root) {
        if (root==null)return true;
        boolean leftFlag = isValidBST2(root.left);
        // 注意pre保存的是前一个节点的根节点，而不是根节点的左子树，因为pre=null开始
        if (pre!=null && pre.val>=root.val)return false;
        pre = root;
        boolean rightFlag = isValidBST2(root.right);
        return leftFlag&rightFlag; //注意左右子树都为有效二叉搜索树
    }

}
