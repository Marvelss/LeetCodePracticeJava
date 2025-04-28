package specialTraining.binaryTree;

import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-04-28 19:54
 * @File : BinaryTree4.java
 * @Description :二叉树与递归-深入理解-129. 求根节点到叶节点数字之和-1（思路可以，但可能不是最优）
 * 总体思路：基于112. 路径总和，多了一个路径的保存参数
 * 注意1：路径保存path需要回溯
 * 2.理解引用和值的关系，解决：回溯和传入参数但参数为变化情况-如下代码是很好的案例-cnt结果一直为0；回溯：path.deleteCharAt(path.length() - 1);
 * private void traverse(TreeNode root, int cnt, StringBuilder path) {
 * if (root == null) return;
 * path.append(root.val);
 * System.out.println("path" + path);
 * if (root.left == root.right) {
 * cnt += Integer.parseInt(path.toString());
 * System.out.println("cnt:" + cnt);
 * }
 * traverse(root.left, cnt, path);
 * traverse(root.right, cnt, path);
 * //        回溯
 * path.deleteCharAt(path.length() - 1);
 * <p>
 * }
 * <p>
 * public int sumNumbers(TreeNode root) {
 * if (root == null) return 0;
 * StringBuilder sb = new StringBuilder();
 * int cnt = 0;
 * traverse(root, cnt, sb);
 * return cnt;
 * }
 */

public class BinaryTree4 {
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

    private int cnt;

    private void traverse(TreeNode root, StringBuilder path) {
        if (root == null) return;
        path.append(root.val);
        System.out.println("path" + path);
        if (root.left == root.right) {
            cnt += Integer.parseInt(path.toString());
            System.out.println("cnt:" + cnt);
        }
        traverse(root.left, path);
        traverse(root.right, path);
//        回溯
        path.deleteCharAt(path.length() - 1);

    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return cnt;
    }
}
