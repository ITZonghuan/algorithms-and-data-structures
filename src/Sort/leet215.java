package Sort;
/**
 * 第k个最大的数
 * 小顶堆，jdk默认的优先队列
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class leet215 {
    public int findKthLargest(int[] nums,int k){
        //优先队列，默认是小根堆
        Queue<Integer> pq = new PriorityQueue<>();
        //维持小根堆中始终当前所有插入元素中最大的k个
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

