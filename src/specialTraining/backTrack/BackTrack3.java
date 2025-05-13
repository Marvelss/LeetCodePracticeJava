package specialTraining.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-13 7:46
 * @File : BackTrack3.java
 * @Description :回溯-子集型-78. 子集-1
 * 总体思路：基于灵神的回溯三问
 * 1.当前操作：path存储nums数字
 * 2.子问题：构造字符串>=i的部分，获取第一个数字（第一层递归）
 * 3.下一个子问题：构造字符串>=i+1的部分，获取第二个数字（第二层递归）
 */

public class BackTrack3 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int startIndex) {
        ans.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
