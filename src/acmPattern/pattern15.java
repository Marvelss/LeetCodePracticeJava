package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-14 11:06
 * @File : pattern15.java
 * @Description : 第一行整数个数N，后跟着N组字符串，每组2行
 注意：键盘读取时，nextLine和next()区别
 */

import java.util.Scanner;

public class pattern15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            for (int i = 0; i <n ; i++) {
                String line1 = in.next();
                String line2 = in.next();
                StringBuilder sb = new StringBuilder(line1);
                sb.insert((line1.length()/2),line2);
                System.out.println(sb.toString());
        }
    }
}
