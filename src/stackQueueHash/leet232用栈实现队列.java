package stackQueueHash;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class leet232用栈实现队列 {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    public void push(int x){
        in.push(x);
    }

    public int pop(){
        inToOut();
        return out.pop();
    }

    public int peek(){
        inToOut();
        return out.pop();
    }

    private void inToOut(){
        if(!out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }


    public boolean empty(){
        return in.isEmpty() && out.isEmpty();
    }
}
