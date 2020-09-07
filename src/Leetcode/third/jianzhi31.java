package Leetcode.third;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class jianzhi31 {
    public boolean validateStackSequences(int[] pushed,int [] popped){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
