package specialTraining.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Vagrant
 * @Time: 2025-05-15 15:08
 * @File : BackTrack10.java
 * @Description :回溯-子集型-93. 复原 IP 地址-2
 * 总体思路：与131. 分割回文串类似，获取一串字符串
 * 关键点：
 * 1.如何取子串：使用
 *         for (int i = startIndex; i < s.length(); i++) {
 *             if (isValid(s, startIndex, i)) {
 * 2.同样使用下标插入分割点
 * 3.判断有效IP地址
 * 3.1不能以0开头
 * 3.2数字大小不能超过255
 */

public class BackTrack10 {
    List<String> ans = new ArrayList<>();


    //[start, end]
    private boolean isValid(StringBuilder s, int start, int end){
        if(start > end)
            return false;
        if(s.charAt(start) == '0' && start != end)
            return false;
        int num = 0;
        for(int i = start; i <= end; i++){
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if(num > 255)
                return false;
        }
        return true;
    }

    private void dfs(StringBuilder s, int startIndex, int point) {
        if (point == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                ans.add(s.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s.insert(i + 1, ".");
                dfs(s, i + 2, point + 1);
                s.deleteCharAt(i + 1);
            }else break;
        }
    }

    public List<String> restoreIpAddresses(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        dfs(stringBuilder, 0, 0);
        return ans;
    }
}
