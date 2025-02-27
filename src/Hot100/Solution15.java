package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-26 21:46
 * @File : Solution15.java
 * @Description : 回溯-491. 非递减子序列
 1.去重
 2.path不符合节点的条件
 2.1path不为空且当前节点递减
 2.2当前节点重复
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution15 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] input = {4,4,3,2,1};
        System.out.println(new Solution15().findSubsequences(input));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, path, 0);
        return ans;
    }

    public void backTracking(int[] candidates, List<Integer> path, int startIndex) {
        if (path.size() > 1) ans.add(new ArrayList<>(path));
        HashSet<Integer> used = new HashSet<>();
        for (int i = startIndex; i < candidates.length; i++) {
            if (path.size() >=1&& candidates[i] < path.get(path.size() - 1) || used.contains(candidates[i])) continue;
            used.add(candidates[i]);
            path.add(candidates[i]);
            backTracking(candidates, path, i + 1);
            path.remove(path.size() - 1);
        }

    }

}
