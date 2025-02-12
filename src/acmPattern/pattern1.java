package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-12 9:32
 * @File : pattern1.java
 * @Description : 多行输入，每行2各整数
 */

import java.util.Scanner;

public class pattern1 {
    public static void Main(String []args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a+b);
        }
    }
}
