package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-13 12:37
 * @File : pattern11.java
 * @Description : 第一行读取整数个数N，后跟着N行两个整数，且映射到Map
 */

import java.util.HashMap;
import java.util.Scanner;

public class pattern11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
            while (n-->0){
                int a = in.nextInt();
                int b = in.nextInt();
                map.put(a,b);
            }
        }
    }
}
