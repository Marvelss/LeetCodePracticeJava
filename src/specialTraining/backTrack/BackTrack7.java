package specialTraining.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-13 10:27
 * @File : BackTrack7.java
 * @Description :回溯-排列型-46. 全排列-2
 * 总体思路：基于77. 组合，区别在于已经用过的值也需要考虑，dfs中的startIndex从i开始而不是i+1，且使用used标记，避免重复使用某个值
 * 关键点：判断当前值是否使用
 * 1.创建used标记，2.若当前值使用，则跳过该次代码 if (used[i]) continue;
 */

//
//
//class Solution {
//    List<List<Integer>> ans = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//    boolean[] used;
//
//    public List<List<Integer>> permute(int[] nums) {
//        used = new boolean[nums.length];
//        dfs(nums);
//        return ans;
//    }
//
//    void dfs(int[] nums) {
//        if (path.size() == nums.length) {
//            ans.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i]) continue;
//            used[i] = true;
//            path.add(nums[i]);
//            dfs(nums);
//            used[i] = false;
//            path.remove(path.size() - 1);
//        }
//    }
//}


public class BackTrack7 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void dfs(int[] nums, int startIndex, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, i, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];

        dfs(nums, 0, used);
        return ans;
    }
}
