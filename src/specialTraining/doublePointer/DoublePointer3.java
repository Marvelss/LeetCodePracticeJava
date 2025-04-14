package specialTraining.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-04-13 19:22
 * @File : DoublePointer3.java
 * @Description :双指针-相向-2824. 统计和小于目标的下标对数目-3(卡在关键点)
 * 总体思路1：暴力解法O(n*n)
 * 总体思路2：双指针O(nlogn)，先排序，然后利用性质
 * 关键点：若[l,r]区间都<target,则l与[l+1,r]的数都符合题解
 */

public class DoublePointer3 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        System.out.println(nums);
        int cnt = 0;
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            if (nums.get(l) + nums.get(r) < target) {
                cnt += r - l;
                l++;
                System.out.println(l);
                System.out.println(r);
                System.out.println("----------");
            } else {
                r--;
                System.out.println(l);
                System.out.println(r);
                System.out.println("----------");
            }
        }
        return cnt;
    }

    public int countPairs1(List<Integer> nums, int target) {
        System.out.println(nums);
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) cnt++;
            }
        }
        return cnt;
    }
}
