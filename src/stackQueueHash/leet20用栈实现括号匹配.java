package stackQueueHash;

import java.util.Stack;

public class leet20用栈实现括号匹配 {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char out = stack.pop();
                    boolean a = c == ')' && out != '(';
                    boolean aa = c == ']' && out != '[';
                    boolean aaa = c == '}' && out != '{';
                    if(a || aa || aaa){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
