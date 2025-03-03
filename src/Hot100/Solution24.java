package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-03 15:21
 * @File : Solution24.java
 * @Description : 238. 除自身以外数组的乘积
总体思路：计算前后缀乘积
前缀积：除本身外的其他元素乘积，ans[i]=nums[i-1]*ans[i-1];
后缀积：tmp *= nums[i + 1]，且同时乘前缀积得到答案，ans[i] *= tmp;
注意点：
后缀乘积下标从int i = len - 2开始倒叙遍历

 */

import java.util.Arrays;

public class Solution24 {
    private int[] ans;
    private int[] ans1;

    public int[] productExceptSelf(int[] nums) {
        ans = new int[nums.length];
        ans1 = new int[nums.length];
        ans[0]=1;
        ans1[nums.length-1]=1;
//        计算左乘积
        for (int i = 1; i < nums.length; i++) {
            ans[i]=nums[i-1]*ans[i-1];
        }

//        计算右乘积
        for (int i = nums.length-2; i >=0 ; i--) {
            ans1[i] = ans1[i+1] * nums[i+1];
        }
        System.out.println(Arrays.toString(ans));
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i]*ans1[i];
        }
        return ans;
    }
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] ans = new int[len];
        ans[0] = 1;

        // 计算左乘积
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // 计算右乘积并直接更新结果
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }

        return ans;
    }
}
