package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-26 19:51
 * @File : Solution12.java
 * @Description : 回溯法-77. 组合
 1.传入参数
 n:所有集合;k:目标组合个数;path:当前路径元素
 2.path的个数==k
 3.path放入元素，递归，path回溯

注意ans.add();传入的是new ArrayList<>(path)而不是path，因为单个path传入，只是传入了引用，值会修改，当遍历完所有集合后，path=0
 */

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;

public class Solution12 {
    public static void main(String[] args) {
        System.out.println(new Solution12().combine(4,2));

    }
    //    结果
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, path, 1);
        return ans;
    }

    public void backTracking(int n, int k, List<Integer> path, int startIndex) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTracking(n, k, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

