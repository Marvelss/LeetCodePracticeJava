package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-12 15:51
 * @File : pattern5.java
 * @Description : 每行输入a、b，输出空一行
 */

import java.util.Scanner;

public class pattern5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a+b);
            System.out.println();
        }
    }
}
