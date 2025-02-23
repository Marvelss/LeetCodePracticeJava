package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-23 19:14
 * @File : Solution.java
 * @Description : 461. 汉明距离
 思路1：直接使用Integer.bitCount()可以计算二进制1的个数
 思路2：比较二进制每一位数，注意移位
 注意：&按位与保留二进制原数、^异或和或只在输入1为1，输入2为1时，结果不同，其他情况一样
 */



public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    public int hammingDistance1(int x, int y) {
        int ans=0;
        for (int i = 0; i < 32; i++) {
            int a=x>>i &1,b=y>>i &1;
            ans+=a^b;
        }
        return ans;
    }
}
