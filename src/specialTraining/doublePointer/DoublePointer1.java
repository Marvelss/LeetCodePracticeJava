package specialTraining.doublePointer;

/**
 * @Author : Vagrant
 * @Time: 2025-04-13 16:50
 * @File : doublePointer1.java
 * @Description : 双指针-相向-167. 两数之和 II - 输入有序数组-1
 * 总体思路：利用升序性质，分别从两边指针向中间移动
 */

public class DoublePointer1 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
                System.out.println(l);
                System.out.println(r);
                System.out.println("----------");
            }
            else if(numbers[l] + numbers[r] < target) {
                l++;
                System.out.println(l);
                System.out.println(r);
                System.out.println("----------");
            }
            else return new int[]{l + 1, r + 1};
        }
        return new int[]{-1, -1};
    }
}
