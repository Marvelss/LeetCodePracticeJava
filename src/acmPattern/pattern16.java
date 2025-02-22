package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-14 11:26
 * @File : pattern16.java
 * @Description : 首行输入整数个数N，后跟着N行内容包含数字与字符串
 */

import java.util.Scanner;

public class pattern16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            for (int i = 0; i <n ; i++) {
                String line1 = in.next();
                StringBuilder sb = new StringBuilder(line1);
                for (int j = 0; j <sb.length()-1 ; j+=2) {
                    String temp = sb.substring(j,j+1);
                    sb.replace(j,j+1,sb.substring(j,j+1));
                    sb.replace(j+1,j+2,temp);
                }
                System.out.println(sb.toString());
            }
        }
    }
}
