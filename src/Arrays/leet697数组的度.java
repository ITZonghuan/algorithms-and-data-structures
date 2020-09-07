package Arrays;

import java.util.HashMap;
import java.util.Map;

public class leet697数组的度 {
    public int findShortestSubArray(int[] nums){
        Map<Integer,Integer> mapCnt = new HashMap();
        Map<Integer,Integer> mapLastIndex = new HashMap();
        Map<Integer,Integer> mapFirstIndex = new HashMap();
        for(int i=0;i<nums.length;i++){
            mapCnt.put(nums[i],mapCnt.getOrDefault(nums[i],0) + 1);
            mapLastIndex.put(nums[i],i);
            if(!mapFirstIndex.containsKey(nums[i])){
                mapFirstIndex.put(nums[i],i);
            }
        }

        int maxCut = 0;
        for(int num:nums){
            maxCut = Math.max(maxCut,mapCnt.get(num));
        }

        int shortestLen = nums.length;
        for(int i=0;i<nums.length;i++){
            if(mapCnt.get(nums[i]) != maxCut) continue;
            shortestLen = Math.min(shortestLen,mapLastIndex.get(nums[i]) - mapFirstIndex.get(nums[i]) + 1);
        }
        return shortestLen;
    }
}
