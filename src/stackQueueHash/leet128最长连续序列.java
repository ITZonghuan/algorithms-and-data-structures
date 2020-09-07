package stackQueueHash;

import java.util.HashMap;
import java.util.Map;

public class leet128最长连续序列 {
    public int longestConsecutive(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(num)) continue;
            //以num-1结尾
            int left = map.getOrDefault(num-1,0);
            //以num+1开头
            int right = map.getOrDefault(num+1,0);
            int sum = left + 1 + right;
            max = Math.max(max,sum);
            //标记此数已经处理过
            map.put(num,-1);
            map.put(num-left,sum);
            map.put(num+right,sum);
        }
        return max;
    }
}
