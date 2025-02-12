package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-12 9:39
 * @File : pattern2.java
 * @Description : 多组数据，第一行一个整数N，后面N行a和b
 */

import java.util.Scanner;

public class pattern2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            while (n-->0) {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(a + b);
                in.close();
            }
        }
    }
}
