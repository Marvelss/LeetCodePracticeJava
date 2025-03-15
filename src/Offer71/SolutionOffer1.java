package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-15 19:41
 * @File : SolutionOffer1.java
 * @Description : LCR 120. 寻找文件副本
 总体思路1：键id：-值：出现频率
 总体思路2：使用索引来映射值，看似哈希表
 若documents[documents[i]]=documents[i]，则存在重复值，如下标4：对应值2；与下标2：对应值2
 */

import java.util.HashMap;

public class SolutionOffer1 {
    public int findRepeatDocument(int[] documents) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < documents.length; i++) {
            int val = map.getOrDefault(documents[i], 0);
            if (val != 0) return documents[i];
            map.put(documents[i], val + 1);
        }
        return 0;
    }

    public int findRepeatDocument1(int[] documents) {
        int i = 0;
        while (i < documents.length) {
            if (i == documents[i]) {
                i++;
                continue;
            }
            if (documents[documents[i]] == documents[i]) {
                return documents[i];
            }
            int temp = documents[i];
            documents[i] = documents[temp];
            documents[temp] = temp;
        }
        return -1;
    }
}
