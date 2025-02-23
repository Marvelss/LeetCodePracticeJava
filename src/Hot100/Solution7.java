package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-23 15:12
 * @File : Solution7.java
 * @Description : 169. 多数元素
 思路1：HashMap记录数字对应频率
 思路2：摩尔投票法，正负抵消思想
 若票数为0，则假设当前众数x=num，若num==x则票数自增1，否则-1
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution7 {
    public int majorityElement2(int[] nums) {
        int mode = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) mode = num;
            vote += num == mode ? 1 : -1;
        }

        return mode;
    }


    public static Integer findKeyByValue(Map<Integer, Integer> map, Integer targetValue) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(targetValue)) {
                return entry.getKey();
            }
        }
        return null; // 如果没有找到对应的键，返回 null
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> num = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (num.containsKey(nums[i])) {
                int count = num.get(nums[i]) + 1;
                num.put(nums[i], count);
            } else {
                num.put(nums[i], 1);
            }
        }
        int res = 0;
        for (Integer value : num.values()) {
            res = Math.max(res, value);
        }
        return findKeyByValue(num, res);
    }
}
