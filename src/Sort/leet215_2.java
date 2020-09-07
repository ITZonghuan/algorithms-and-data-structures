package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 第k个最小的数
 * 大顶堆
 */
public class leet215_2 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,5,4};
        System.out.println(findKthSmallest(nums,6));
    }
    public static int findKthSmallest(int[] nums,int k){
        //大根堆就是要复写Comparetor类的compare方法
        Queue<Integer> pq = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return b - a;
            }
        });
//        Queue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
