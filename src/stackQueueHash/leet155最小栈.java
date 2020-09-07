package stackQueueHash;

import java.util.Stack;

/**
 * 用栈实现最小值栈
 * 用栈实现最小值队列，可先用栈实现队列，再将问题转换为最小值栈问题
 */
public class leet155最小栈 {
    class MinStack{
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        int min;
        public MinStack(){
            dataStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x){
            dataStack.push(x);
            min = Math.min(min,x);
            minStack.push(x);
        }

        public void pop(){
            int dataPop = dataStack.pop();
            int minPop = minStack.peek();
            if(dataPop == minPop){
                minStack.pop();
            }
        }

        public int top(){
            return dataStack.peek();
        }

        public int getMin(){
            return minStack.peek();
        }
    }
}
