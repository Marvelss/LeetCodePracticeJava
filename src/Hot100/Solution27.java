package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-05 16:09
 * @File : Solution27.java
 * @Description : 215. 数组中的第K个最大元素
 总体思路：基于快排原理，若基准数的索引正好是 N−k ，则意味着它就是第 k 大的数字
注意点：
1.若k <= big.size()，表明k在大的数组内
2.若nums.size() - small.size() < k,其中，nums.size() - small.size()表明大于基准元素的数量
3.若2.条件为true，在小的数组中，则k为： k - (nums.size() - small.size())，表明k在小数组中的相对位置
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution27 {
    private int quickSelect(List<Integer> nums, int k) {
        //        随机划分
        int pivot = nums.get(new Random().nextInt(nums.size()));
//        分别存储
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (Integer num : nums) {
            if (num > pivot) big.add(num);
            else if (num < pivot) small.add(num);
            else equal.add(num);
        }

        if (k <= big.size()) return quickSelect(big, k);
        if (nums.size() - small.size() < k) return quickSelect(small, k - nums.size() + small.size());
        return pivot;
    }

    public int findKthLargest(int[] nums, int k) {
        List<Integer> nums1 = new ArrayList<>();
        for (int num : nums) {
            nums1.add(num);
        }
        return quickSelect(nums1, k);
    }
}
