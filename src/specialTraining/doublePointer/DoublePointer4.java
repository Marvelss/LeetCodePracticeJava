package specialTraining.doublePointer;

import java.util.Arrays;

/**
 * @Author : Vagrant
 * @Time: 2025-04-14 16:25
 * @File : DoublePointer4.java
 * @Description :双指针-相向-16. 最接近的三数之和（卡在s与target比较，而不是s与0，以维护当前和与目标差值）-3
 * 总体思路：基于15. 三数之和-3，
 * 若s-target<以维护当前和与目标差值
 * 注意：且s与target比较，而不是s与0
 */

public class DoublePointer4 {

    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int min_diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > target) {
                    if (s - target < min_diff) {
                        min_diff = s - target;
                        ans = s;
                    }
                    k--;
                    System.out.println(j);
                    System.out.println(k);
                    System.out.println("----------");
                } else if (s < target) {
                    if (target - s < min_diff) {
                        min_diff = target - s;
                        ans = s;
                    }
                    j++;
                    System.out.println(j);
                    System.out.println(k);
                    System.out.println("----------");
                } else {
                    return s;
                }
            }
        }
        return ans;
    }

}
