package specialTraining.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-09 14:31
 * @File : BinaryTree31.java
 * @Description :二叉树与递归-BFS-2641. 二叉树的堂兄弟节点 II-3（思路想到，但代码未写出，关键点：站在父节点看子节点）
 * 总体思路（自己想）：
 * 1.计算每层节点和
 * 2.从第二层开始，当前节点左右节点的值=总和-左右节点和
 * 总体思路（灵神思路）：
 * 1.遍历一次，计算下一层节点和
 * 2.再遍历一次，修改当前层的左右节点的值为：总节点和-左右节点和
 */

public class BinaryTree31 {
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


    public TreeNode replaceValueInTree(TreeNode root) {
        List<TreeNode> cur = new ArrayList<>();
        root.val = 0;
        cur.add(root);
        while (!cur.isEmpty()) {
            int len = cur.size();
            List<TreeNode> nxt = new ArrayList<>();
            int nxtSum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode topNode = cur.get(i);
                if (topNode.left != null) {
                    nxt.add(topNode.left);
                    nxtSum += topNode.left.val;
                }
                if (topNode.right != null) {
                    nxt.add(topNode.right);
                    nxtSum += topNode.right.val;
                }
            }
            for (int i = 0; i < len; i++) {
                int childrenSum = 0;
                TreeNode topNode = cur.get(i);
                if (topNode.left != null) {
                    childrenSum += topNode.left.val;
                }
                if (topNode.right != null) {
                    childrenSum += topNode.right.val;
                }
                if (topNode.left != null) topNode.left.val = nxtSum - childrenSum;
                if (topNode.right != null) topNode.right.val = nxtSum - childrenSum;
            }
            cur = nxt;
        }
        return root;
    }
}
