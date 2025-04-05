package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-04-03 10:05
 * @File : Solution57.java
 * @Description : 76. 最小覆盖子串
 总体思路：
 0.初始化内容
 cntS，cntT：比较记录值
 ansLeft，ansRight：记录答案

 1.右端进入窗口
 2.更新答案，while (isCovered(cntS, cntT))
 3.左端移出窗口

 注意：为什么while (isCovered(cntS, cntT)) 涵盖才开始循环，答：记录最后一次满足条件的最小窗口
 以第一次出现涵盖符合题解为例，不断循环找到最小窗口
 */

import java.util.Arrays;

public class Solution57 {
    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) return false;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int left = 0, ansLeft = -1, ansRight = s.length();
        char[] S = s.toCharArray();
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }
        for (int right = 0; right < S.length; right++) {
//            1.右端进入
            cntS[S[right]]++;
//            当出现涵盖的时候，记录最后一次满足条件的最小窗口
            while (isCovered(cntS, cntT)) {
//                记录答案
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
//                左端移除
                cntS[S[left]]--;
                left++;

            }

        }
        System.out.println(ansLeft + ansRight);
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);

    }
}
