package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-27 21:52
 * @File : Solution17.java
 * @Description :回溯-46. 全排列
    思路：与组合的不同点在于，添加了used数组，记录已使用了哪些值
    当path和nums长度一致时收割节点
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums);
        return ans;
    }

    void dfs(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
