package specialTraining.binaryTree;

import java.util.*;

/**
 * @Author : Vagrant
 * @Time: 2025-04-29 10:42
 * @File : BinaryTree9.java
 * @Description :二叉树与递归-灵活运用-199. 二叉树的右视图-1(使用BFS，该专题应用DFS)
 * 总体思路1：层序遍历
 * 总体思路2：1.若数的深度==ans的长度（ans的长度代表二叉树的每一层），则符合题解2.先遍历右子树，再左子树，因为题意为右视图，要先找右边的节点
 * 注意点：计算节点深度，使用traverse(root.right, depth + 1);
 */

public class BinaryTree9 {
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

    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        deque.push(root);
        System.out.println(deque.size());
        int cnt = 0;
        while (!deque.isEmpty()) {
            int levelSize = deque.size(); // 记录当前层的节点数
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode topNode = deque.poll();
                if (i == levelSize - 1) tempList.add(topNode.val);

                if (topNode.left != null) deque.add(topNode.left);
                if (topNode.right != null) deque.add(topNode.right);
                tempList.add(topNode.val);
                System.out.println("第" + cnt + "层:" + topNode.val);
            }
            cnt++;
            ans.add(tempList.get(tempList.size() - 1));
        }
        return ans;
    }

    private void traverse(TreeNode root, int depth) {
        if (root == null) return;
        if (ans.size() == depth) ans.add(root.val);
        traverse(root.right, depth + 1);
        traverse(root.left, depth + 1);
    }

    public List<Integer> rightSideView1(TreeNode root) {
        traverse(root, 0);
        return ans;
    }
}
