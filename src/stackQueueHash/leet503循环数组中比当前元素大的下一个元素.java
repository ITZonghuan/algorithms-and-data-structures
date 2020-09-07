package stackQueueHash;

import java.util.Arrays;
import java.util.Stack;

public class leet503循环数组中比当前元素大的下一个元素 {
    public int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        Stack<Integer> index = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<2*n;i++){
            int num = i % n;
            while(!index.isEmpty() && nums[index.peek()] < nums[num]){
                res[index.pop()] = nums[num];
            }
            if(i < n){
                index.push(i);
            }
        }
        return res;
    }
}
