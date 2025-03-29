package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-27 19:33
 * @File : Solution16.java
 * @Description : 300. 最长递增子序列（动规）
 总体思路
 1.dp[i]：以nums[i]结尾的最长递增子序列
 2.if nums[j]<nums[i] dp[i]=max(dp[j]+1,dp[i])
 3.dp[0]=1
 4.从左到右
 */

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution16 {
    int MaxLen = 0;
    int minNumIndex = 0;
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 2, 3};
        System.out.println(new Solution16().lengthOfLIS(input));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            ans = Math.max(ans, dp[i]);
            System.out.println("i=" + i + "---结果=" + ans);
        }
        return ans;
    }

    private int findMinIndex(int[] nums) {
        int num = 0;
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < maxNum) {
                maxNum = nums[i];
                num = i;
            }
        }
        return num;
    }

    public void backTracking(int[] candidates, List<Integer> path, int startIndex) {
        if (path.size() >= 1) MaxLen = Math.max(path.size(), MaxLen);
        for (int i = startIndex; i < minNumIndex + path.size() + 2; i++) {
            if (path.size() >= 1 && candidates[i] <= path.get(path.size() - 1)) continue;
            path.add(candidates[i]);
            backTracking(candidates, path, i + 1);
            path.remove(path.size() - 1);
        }
    }


}
