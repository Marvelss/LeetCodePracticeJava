package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-12 15:56
 * @File : pattern6.java
 * @Description : 第一行为N个整数，每行第一个整数个数N，后面跟着N个整数
 * 注意row==0时，不要空行，使得前一组和下一组之间没有空行
 */

import java.util.Scanner;

public class pattern6 {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int row = in.nextInt();
            if (row==0)break;
            while (row-->0){
                int n = in.nextInt();
                int sum = 0;
                for (int i=0;i<n;i++){
                    sum += in.nextInt();
                }
                System.out.println(sum);
                if (row!=0)System.out.println();
            }
        }
    }
}
