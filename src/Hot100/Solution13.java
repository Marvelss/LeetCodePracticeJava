package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-26 20:39
 * @File : Solution13.java
 * @Description : 回溯-39. 组合总和(看了carl的回溯法代码秒了)
 1.n:candidates;k=总和;path:默认
 2.终止条件path的和==k或path的和>k
 注意点：元素可重复使用，所以递归时startIndex不用+1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution13 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backTracking(candidates,target,path,0);

        return ans;
    }

    public int calculation(List<Integer> nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public void backTracking(int[] candidates, int k, List<Integer> path, int startIndex) {
        if (calculation(path) == k) {
            ans.add(new ArrayList<>(path));
            return;
        } else if (calculation(path) > k) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTracking(candidates, k, path, i);
            path.remove(path.size()-1);
        }

    }

}
