package acmPattern;/*
 * @Author : Vagrant
 * @Time: 2025-02-12 16:11
 * @File : pattern7.java
 * @Description : 输入一行字符串
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class pattern7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String line = in.nextLine();
            String[] items = line.split(" ");
            double sum = 0;
            boolean isUnknow =false;
            List<String> validItems = Arrays.asList("A", "B", "C", "D", "F");
            for (String item : items) {
                if (!validItems.contains(item)) {
                    isUnknow = true;
                    break;
                }
                if (item.equals("A")) sum += 4;
                else if (item.equals("B"))sum += 3;
                else if (item.equals("C"))sum += 2;
                else if (item.equals("D"))sum += 1;
            }
            if (isUnknow) System.out.println("Unknown");
            else System.out.printf("%.2f\n",sum/items.length);
        }
    }
}
