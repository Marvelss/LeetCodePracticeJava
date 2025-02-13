package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-13 12:43
 * @File : pattern12.java
 * @Description : 输入一个整数，输出特定数字图形
 */

import java.util.Scanner;

public class pattern12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            //上半部分金字塔
            for (int i = 1; i <=n; i++) {
                print(n-i,i);
            }
            //下半部分金字塔
            for (int i = n-1; i >=1 ; i--) {
                print(n-i,i);
            }
        }
    }
    public static void print(int blank,int n){
        // 补齐空格
        for (int i = 0; i <blank ; i++) {
            System.out.print(" ");
        }
//        打印左半边
        for (int i = 1; i <=n ; i++) {
            System.out.print(i);
        }
//        打印右半边
        for (int i = n-1; i >0 ; i--) {
            System.out.print(i);
        }
        System.out.println();
    }
}
