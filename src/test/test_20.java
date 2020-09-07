package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test_20 {
    public int[] lefter(int [] arr){
        Stack<Integer> stack = new Stack<>();
        List<Integer> left_big = new ArrayList<Integer>();
        List<Integer> right_big = new ArrayList<Integer>();
        for(int i = 0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.add(i);
                left_big.add(-1);
            }
            else if(arr[stack.peek()]>arr[i]){
                left_big.add(arr[i]);
                stack.add(i);
            } else{
                int pop = stack.pop();
                while(arr[pop] < arr[i]){
                    pop = stack.pop();
                };

            }
        }
        return new int[0];
    }
}
