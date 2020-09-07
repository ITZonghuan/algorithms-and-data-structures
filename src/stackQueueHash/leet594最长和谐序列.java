package stackQueueHash;

import java.util.HashMap;
import java.util.Map;

public class leet594最长和谐序列 {
    public int findLHS(int[] nums){
        Map<Integer,Integer> map = new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int longest = 0;
        for(int k:map.keySet()){
            if(map.containsKey(k+1)){
                longest = Math.max(longest,map.get(k) + map.get(k+1));
            }
        }
        return longest;
    }
}
