package Leetcode._0630;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * 单调递减队列
 */
public class jianzhi59_1 {
    public int[] maxSlidingWindow(int[] nums,int k){
        if(nums.length == 0 || k==0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int [] res = new int[nums.length-k+1];
        for(int i=0;i<k;i++){ //未形成窗口
            while(!deque.isEmpty() && deque.peekLast()<nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i =k;i<nums.length;i++){ //形成窗口后
            if(deque.peekFirst() == nums[i-k]) deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            res[i-k+1] = deque.peekFirst();
        }
        return res;
    }
}
