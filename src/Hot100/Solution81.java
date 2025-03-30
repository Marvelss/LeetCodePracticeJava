package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-30 20:05
 * @File : Solution81.java
 * @Description : 128. 最长连续序列
 总体思路：还是比较保留解法
 1.将数组转为hash中
 2.逐个遍历
 3.优化点：遍历x时，若x-1出现在集合中，则可跳过，避免重复计算，减少时间
 4.注意遍历以hash集合为基准
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution81 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            map.add(num);
        }
        for (Integer i : map) {
            if (map.contains(i - 1)) continue;
            int y = i + 1;
            while (map.contains(y)) y++;
            ans=Math.max(ans,y-i);
        }
        return ans;
    }
}
