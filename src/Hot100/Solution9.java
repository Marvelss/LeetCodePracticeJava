package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-23 16:19
 * @File : Solution9.java
 * @Description : 448. 找到所有数组中消失的数字
 思路：利用索引与对应值的关系，若值>0则，值未出现过，该值对应索引则为结果
 index = Math.abs(nums[i]) - 1
 通过nums[index]*=-1标记值为负数，表面该值出现过
 */

import java.util.ArrayList;
import java.util.List;

public class Solution9 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] > 0)nums[Math.abs(nums[i]) - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0)res.add(i+1);
        }
        return res;
    }
}
