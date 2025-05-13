package specialTraining.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-13 9:42
 * @File : BackTrack5.java
 * @Description :回溯-组合型与剪枝-216. 组合总和 III-1
 * 总体思路：基于77. 组合，1.添加sum变量2.修改i的循环条件（因为题干数要求数子1-9）3.修改收割结果条件
 */

public class BackTrack5 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        dfs(n, k, 1, 0);
        return ans;
    }

    private void dfs(int n, int k, int startIndex, int sum) {
        if (path.size() == k && sum == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            dfs(n, k, i + 1, sum);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
