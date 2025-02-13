package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-13 12:56
 * @File : pattern14.java
 * @Description : 第一行整数个数N，后跟着N行字符串
 */

import java.util.HashMap;
import java.util.Scanner;

public class pattern14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
//            5\
//            Line 1
//            Line 2
//            in.nextLine();用来读取整数后的换行符，否则读取不到第二行后的字符串
            in.nextLine();
            for (int i = 0; i <n ; i++) {
                String singleLine = in.nextLine().trim();
                StringBuilder sb = new StringBuilder();
                System.out.println(sb.toString());
            }
        }
    }
}
