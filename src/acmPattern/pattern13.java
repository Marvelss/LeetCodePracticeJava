package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-13 12:51
 * @File : pattern13.java
 * @Description : 每行输入一个字符和一个整数，遇到特殊字符结束
 */

import java.util.HashMap;
import java.util.Scanner;

public class pattern13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            if (line.equals("@"))break;
            String[] sp = line.split(" ");
            char ch = sp[0].charAt(0);
            int n = Integer.parseInt(sp[1]);
            }
    }
}
