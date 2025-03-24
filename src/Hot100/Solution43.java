package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-20 16:26
 * @File : Solution43.java
 * @Description : 75. 颜色分类
 思路：刷油漆
 三个指针:i刷为数字2，n1刷为数字1，n0刷为数字0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution43 {
    public void sortColors(int[] nums) {
        int n0 = 0, n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i]=2;
            if (num<2)nums[n1++]=1;
            if (num<1)nums[n0++]=0;

        }
    }

    public static void main(String[] args) {
        Solution43 a = new Solution43();
        int[]p = new int[6];
        List<Integer>list = new ArrayList<>(Arrays.asList(2, 0, 2, 1, 1, 0));
        for (int i = 0; i < p.length; i++) {
            p[i]=list.get(i);
        }
        a.sortColors(p);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }
}
