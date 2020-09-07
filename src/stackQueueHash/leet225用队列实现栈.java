package stackQueueHash;

import java.util.LinkedList;
import java.util.Queue;

public class leet225用队列实现栈 {
    public class MyStack{
    private Queue<Integer> queue;
    public MyStack(){
      queue = new LinkedList<>();
    }

    public void push(int x){
        queue.add(x);
        int cnt = queue.size();
        while(cnt-- > 1){
            queue.add(queue.poll());
        }
    }

    public int pop(){
        //这两个方法都是错误时报错
        return queue.remove();
    }

    public int top(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
    }
}
