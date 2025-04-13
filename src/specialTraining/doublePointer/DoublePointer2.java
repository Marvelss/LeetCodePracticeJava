package specialTraining.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-04-13 17:26
 * @File : doublePointer2.java
 * @Description :双指针-相向-15. 三数之和-3（卡在步骤3）
 * 1.题解注顺序不重要--->先排序
 * 2.基于167.思路，采用整体思路，将一个元素看成target，另外两个采用两数之和方法
 * 3.去重答案（未写出代码）
 * 3.1因已排序，若当前元素等于前一个元素，则跳过；nums[i]==nums[i-1]，nums[j]==nums[j-1]，nums[k]==nums[k-1]
 */

public class DoublePointer2 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0) {
                    k--;
                    System.out.println(j);
                    System.out.println(k);
                    System.out.println("----------");
                } else if (s < 0) {
                    j++;
                    System.out.println(j);
                    System.out.println(k);
                    System.out.println("----------");
                } else {
                    ans.add(new ArrayList<>(Arrays.asList(x, nums[k], nums[j])));
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1};
        int[] nums2 = {-1, 0, 1, 2, -1, -4};
        System.out.println(new DoublePointer2().threeSum(nums2));
    }
}

