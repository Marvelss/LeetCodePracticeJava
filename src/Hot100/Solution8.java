package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-23 16:06
 * @File : Solution8.java
 * @Description : 338. 比特位计数
 思路：判断奇/偶数
 若为奇数，1的个数一定比前一个数（偶数）多一个1，多的是二进制最低为的1
 若为偶数，1的个数一定是数/2后哪个数字的个数一样，因为偶数最低为0，除以2相对于右移1位，抹去0，1个数不变
 */

public class Solution8 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0]=0;
        for (int i = 1; i <= n; i++) {
            if (i / 2 == 0) res[i] = res[i / 2];
            else res[i] = res[i - 1] + 1;
        }
        return res;
    }
}
