package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-26 21:22
 * @File : Solution14.java
 * @Description : 回溯-78. 子集
 思路：基于组合的解题思路，不同点在于：path收集每个子节点的情况，而不是只针对叶子节点（去除终止条件判断）
 */

import java.util.ArrayList;
import java.util.List;

public class Solution14 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        backTracking(nums,path,0);
        return ans;
    }

    public void backTracking(int[] candidates, List<Integer> path, int startIndex) {
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            ans.add(new ArrayList<>(path));
            backTracking(candidates, path, i+1);
            path.remove(path.size() - 1);
        }

    }
}
