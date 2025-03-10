package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-10 14:04
 * @File : Solution35.java
 * @Description : 49. 字母异位词分组
 总体思路1：计算每个单词与z的char值（不正确，可能字母不一样，但差值一样）
 总体思路2：排序每个字符串，若相同，则为答案
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution35 {
    HashMap<String, List<String>> map = new HashMap<>();

    public List<List<String>> groupAnagrams1(String[] strs) {
        for (String str : strs) {
            char[] c = str.toCharArray();
            int keyTemp = 0;
            for (char c1 : c) {
                keyTemp += c1 - 'z';
            }
//            map.computeIfAbsent(keyTemp, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            map.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
