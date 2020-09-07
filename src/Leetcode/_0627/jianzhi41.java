package Leetcode._0627;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 * 有几点暂时未理解，比如lambda，比如大顶堆构建方法
 */
public class jianzhi41 {
    Queue<Integer> A,B;
    public jianzhi41(){
        //最小的元素在队列的头部因而最先被取出
        A = new PriorityQueue<>();//小顶堆，保存较大的一半
        B = new PriorityQueue<>((x,y) -> (y-x));//大顶堆，保存较小的一半
    }
    //本算法核心之处
    public void addNum(int num){
        if(A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian(){
        return A.size()!=B.size()?A.peek():(A.peek() + B.peek()/2.0);
    }
}
