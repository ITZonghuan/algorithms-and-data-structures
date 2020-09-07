package Leetcode.third;


import java.util.Stack;

/**
 * 包含min函数的栈
 */
public class jianzhi30 {
    class MinStack{
        Stack<Integer> A,B;
        public MinStack(){
            A = new Stack<>();
            B = new Stack<>();
        }
        public void push(int x){
            A.add(x);
            if(B.empty() || B.peek() >= x){
                B.add(x);
            }
        }
        public void pop(){
            if(A.pop().equals(B.peek())){
                B.pop();
            }
        }
        public int top(){
            return A.peek();
        }
        public int min(){
            return B.peek();
        }
    }
}
