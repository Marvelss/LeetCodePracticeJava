package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-12 9:50
 * @File : pattern4.java
 * @Description : 每行第一个数为n，后面有n个整数
 */

import java.util.Scanner;

public class pattern4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            if (n==0)break;
            int sum = 0;
            for (int i =0;i<n;i++){
                sum+=in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
