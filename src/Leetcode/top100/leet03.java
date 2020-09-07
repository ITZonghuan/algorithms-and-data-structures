package Leetcode.top100;

import java.util.HashMap;
import java.util.Map;

//滑动窗口解法
public class leet03 {
    public int lengthOfLongestSubstring(String s){
        int n = s.length(),ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        //这个for循环是解题核心
        for(int end = 0,start = 0;end<n;end++){
            char alpha = s.charAt(end);
            if(map.containsKey(alpha)){
                start = Math.max(map.get(alpha),start);
            }
            ans = Math.max(ans,end - start + 1);
            map.put(s.charAt(end),end + 1);
        }
        return ans;
    }
}
