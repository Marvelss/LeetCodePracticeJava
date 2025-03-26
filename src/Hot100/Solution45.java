package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-26 19:23
 * @File : Hot45.java
 * @Description : 621. 任务调度器
 总体思路：分两种情况
 1.任务刚好填满缝隙：tasks.length
 2.任务没有填满缝隙：(num-1)*(n+1))+count
 2.1num：代表最大任务数值的个数，如A、B任务
 2.2n：间隔时间
 2.3count最后一次任务不计算间隔时间，故单独计算,且num-1
 */

public class Solution45 {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        int num = 0;
        int count = 0;
        for (int i = 0; i < tasks.length; i++) {
            arr[tasks[i]-'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i]>num){
                num=arr[i];
                count=1;
            }
            else if(arr[i]==num) count++;
        }
        return Math.max(tasks.length,(num-1)*(n+1))+count;
    }
}
