package Offer71;/*
 * @Author : Vagrant
 * @Time: 2025-03-17 18:06
 * @File : SolutionOffer2.java
 * @Description : LCR 122. 路径加密
 总体思路：遍历添加
 */

public class SolutionOffer2 {
    public String pathEncryption(String path) {
        char[] charList = path.toCharArray();
        String ans = "";
        for (int i = 0; i < charList.length; i++) {
            if (charList[i] == '.') ans += " ";
            else ans += charList[i];
        }
        return ans;
    }
}
