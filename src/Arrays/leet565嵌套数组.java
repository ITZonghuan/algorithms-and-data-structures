package Arrays;

import java.util.HashSet;
import java.util.Set;

public class leet565嵌套数组 {
    public int arrayNesting(int[] nums){
        int result = 0;
        Set<Integer> st = new HashSet();
        for(int i=0;i<nums.length;i++){
            int count = 0,k = i;
            while(!st.contains(nums[k])){
                count++;
                st.add(nums[k]);
                k = nums[k];
            }
            result = Math.max(result,count);
        }
        return result;
    }
}
