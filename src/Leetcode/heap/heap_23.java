package Leetcode.heap;
/**
 * 有一句不懂
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class heap_23 {
    public static void main(String[] args) {
        System.out.println("rrr");
    }
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            this.val = x;
        }
    }
    public ListNode mergeKLists(ListNode [] lists){
        //下面这句着实不懂
        //提供的小根堆 只能比较基本数据类型的封装类,比如 Integer, Double等
        //对于自定义的类，需要提供比较方法
        Queue<ListNode> pq = new PriorityQueue<>((v1,v2) -> v1.val - v2.val);
        for(ListNode list: lists){
            if(list != null){
                pq.offer(list);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }
}
