package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-02-18 21:46
 * @File : Solution1.java
 * @Description :283. 移动零(自想过)

总体思路:i指向0的起始位置，j为遍历下标，若j！=0则从下标i开始，截止到j交换位置，j==0则无动作
关键点：把0看作一个整体（for循环）与非0元素交换位置
注意：先找到第一个元素0的下标
 */

class Solution1 {
    public void moveZeroes(int[] nums) {
        int i = -99;
//        找到第一个0
        for (int h = 0; h < nums.length; h++) {
            if(nums[h]==0){
                i=h;
                break;
            }
        }
        if (i==-99)return ;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[i] = temp;
                for(int left=i+1;left<=j;left++){
                    nums[left] = 0;
                    // System.out.println(Arrays.toString(nums));
                }
                i++;

            }
        }
    }
}