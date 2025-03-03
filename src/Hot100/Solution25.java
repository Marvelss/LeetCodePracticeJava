package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-03 18:56
 * @File : Solution25.java
 * @Description :560. 和为 K 的子数组
 总体思路：pre - k,该前缀和的下一个位置到当前位置的子数组和为k
 注意点：前缀和为0时，个数为1； map.put(0,1);
 */

import java.util.HashMap;
import java.util.Map;

public class Solution25 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);

        }

        return count;
    }

}
