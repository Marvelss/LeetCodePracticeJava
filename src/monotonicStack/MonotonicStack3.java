package monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author : Vagrant
 * @Time: 2025-06-03 16:44
 * @File : MonotonicStack3.java
 * @Description :单调队列-239. 滑动窗口最大值-2
 * 总体思路：1.入，2出，3记录答案
 * 1.入，若队尾元素<=当前元素，则弹出队尾，加入当前元素（元素大的入队）
 * 2.出，若队内元素个数超过k，弹出队首元素（根据当前元素下标-队首元素下标判断个数）
 * 3.记录答案，当i>=k-1时，记录队首元素为答案（因为改队列单调递减）
 * 队列常用操作：peekLast，peekFirst：获取队首尾元素；addLast，addFirst;pollLast，pollFirst
 */

public class MonotonicStack3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
//        1.入
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
//        2.出
            if (i - deque.peekFirst() >= k) deque.pollFirst();
//        3.记录答案
            if (i >= k - 1) ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
