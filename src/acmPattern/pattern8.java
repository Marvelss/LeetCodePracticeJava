package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-13 12:00
 * @File : pattern8.java
 * @Description : 第一行是整数个数N，后面几行是N个整数
 */

import java.util.ArrayList;
import java.util.Scanner;

public class pattern8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            Integer size = in.nextInt();
            if (size==0)break;
            ArrayList<Integer> list= new ArrayList<>();
            for (int i=0;i<size;i++){
                int num = in.nextInt();
                list.add(num);
            }
            for (Integer i : list) {
                System.out.println(i);
            }
            System.out.println("res");
            System.out.println();
        }
    }
}
