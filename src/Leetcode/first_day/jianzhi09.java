package Leetcode.first_day;


import java.util.LinkedList;

/**
 * 用两个栈实现一个队列，队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 */
public class jianzhi09 {
    LinkedList<Integer>A,B;
    public jianzhi09(){
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    public void appendTail(int value){
        A.addLast(value);
    }
    public int deleteHead(){
        if(!B.isEmpty()){
            return B.removeLast();
        }
        if(A.isEmpty()){
            return -1;
        }
        while(!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
