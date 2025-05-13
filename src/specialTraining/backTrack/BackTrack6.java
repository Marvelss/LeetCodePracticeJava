package specialTraining.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-13 10:02
 * @File : BackTrack6.java
 * @Description :回溯-组合型与剪枝-39. 组合总和
 * 总体思路：基于77. 组合，添加一个sum记录总和，若(sum == target)收割结果
 * 剪枝点：            if (sum > target) break;
 */

//
//class Solution {
//    List<List<Integer>> ans = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        backTracking(candidates,target,path,0);
//
//        return ans;
//    }
//
//    public int calculation(List<Integer> nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        return sum;
//    }
//
//    public void backTracking(int[] candidates, int k, List<Integer> path, int startIndex) {
//        if (calculation(path) == k) {
//            ans.add(new ArrayList<>(path));
//            return;
//        } else if (calculation(path) > k) {
//            return;
//        }
//        for (int i = startIndex; i < candidates.length; i++) {
//            path.add(candidates[i]);
//            backTracking(candidates, k, path, i);
//            path.remove(path.size()-1);
//        }
//
//    }
//
//}


public class BackTrack6 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    private void dfs(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum <= target) {
                path.add(candidates[i]);
                sum += candidates[i];
                dfs(candidates, target, i, sum);
                path.remove(path.size() - 1);
                sum -= candidates[i];
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates, target, 0, 0);
        return ans;
    }
}
