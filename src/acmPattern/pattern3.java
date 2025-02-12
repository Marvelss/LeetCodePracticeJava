package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-12 9:47
 * @File : pattern3.java
 * @Description : 一对a、b，含0、0结束
 */

import java.util.Scanner;

public class pattern3 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        while (in.hasNext()){
            int a =in.nextInt();
            int b = in.nextInt();
            if (a==0 && b==0)break;
            System.out.println(a+b);
        }
    }
}
