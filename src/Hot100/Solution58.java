package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-06 13:36
 * @File : Solution58.java
 * @Description : 79. 单词搜索
 总体思路:两次for循环暴力依次作为起点走，
 1.递归返回值：bool，参数：board-题目已知、word-题目已知、i-行、j-列、k-word中的第几个元素
 2.终止条件：下标越界、board与word不符合情况返回F；k长度等于word返回T
 3.单层逻辑：
 3.1标记已走的路
 3.2从从下、上、右、左依次走
 3.3回溯
 */

public class Solution58 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        char[] wordL = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, wordL, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
//        下标越界、board与word不符合情况返回F
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
//        k长度等于word
        if (k == word.length - 1) return true;
//        标记已经走过的
        board[i][j] = '\0';
//        从下、上、右、左依次走
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
//        回溯
        board[i][j] = word[k];
        return res;
    }
}
