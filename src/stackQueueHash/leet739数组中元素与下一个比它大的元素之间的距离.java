package stackQueueHash;

import java.util.Stack;

public class leet739数组中元素与下一个比它大的元素之间的距离 {
    public static void main(String[] args) {
        int[] res = new int[2];
        for(int n:res){
            System.out.println(n);
        }
    }
    public int[] dailyTemperatures(int[] T){
        int n = T.length;
        Stack<Integer> stackIndex = new Stack<>();
        int[] dist = new int[n];
        for(int curIndex = 0;curIndex<n;curIndex++){
            while(!stackIndex.isEmpty() && T[stackIndex.peek()] < T[curIndex]){
                int preIndex = stackIndex.pop();
                int len = curIndex - preIndex;
                dist[preIndex] = len;
            }
            stackIndex.add(curIndex);
        }
        return dist;
    }
}
