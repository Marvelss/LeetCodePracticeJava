package specialTraining.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-15 10:06
 * @File : BackTrack8.java
 * @Description :回溯-排列型-51. N 皇后-2
 * 总体思路：逐层遍历行，将二维数组转为一位数组，计算全排列
 * 一、传入参数：棋盘，总行数，当前行，当前列
 * 二、收割结果（终止条件）：当总行数==当前行
 * 三、单层循环：遍历每一列，在合法的情况下，递归变化行数+1
 * 四、其他
 * 1.判断不符合题意的棋子：
 * 1.1该列中出现重复棋子
 * 1.45°出现重复棋子
 * 1.135°出现重复棋子
 * 2.小技巧：回溯时，使用chessBoard[row][col] = '.';归位
 * 3.其他格式转换代码：Array2List-char[][]转为List
 */

public class BackTrack8 {
    private List<List<String>> ans = new ArrayList<>();

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    private boolean isValid(char[][] chessBoard, int row, int col, int n) {

        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n - 1; i--, j++) {
            if (chessBoard[i][col] == 'Q') return false;

        }
        return true;
    }

    private void backTracking(char[][] chessBoard, int n, int row) {
        if (row == n) {
            ans.add(Array2List(chessBoard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(chessBoard, row, col, n)) {
                chessBoard[row][col] = 'Q';
                backTracking(chessBoard, n, row + 1);
                chessBoard[row][col] = '.';

            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] chars : chessBoard) {
            Arrays.fill(chars, '.');
        }
        backTracking(chessBoard, n, 0);
        return ans;
    }
}
