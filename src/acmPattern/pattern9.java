package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-13 12:08
 * @File : pattern9.java
 * @Description : 输入一个整整数，32位整型范围内（整除取余获取个位数）
 */

import java.util.ArrayList;
import java.util.Scanner;

public class pattern9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = 0;
            while (n > 0) {
                int temp = n % 10;
                n /= 10;
                if (temp%2==0)sum+=temp;
            }
            System.out.println(sum);
            System.out.println();
        }
    }
}
