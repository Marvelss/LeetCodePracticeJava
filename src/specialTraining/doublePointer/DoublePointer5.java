package specialTraining.doublePointer;

import java.util.Arrays;

/**
 * @Author : Vagrant
 * @Time: 2025-04-14 20:49
 * @File : DoublePointer5.java
 * @Description :双指针-相向-611. 有效三角形的个数（卡在以k为target遍历，而不是i）-3
 * 总体思路：基于2824. 统计和小于目标的下标对数目的变体
 * 若nums[i] + nums[j] > x，则nums[i+1]也符合题意，所以ans += j - i;
 */

public class DoublePointer5 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int k = 2; k < nums.length; k++) {
            int x = nums[k];
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > x) {
                    ans += j - i;
                    j--;
                    System.out.println(j);
                    System.out.println(k);
                    System.out.println("----------");
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
}
