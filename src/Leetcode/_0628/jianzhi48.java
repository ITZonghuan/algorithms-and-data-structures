package Leetcode._0628;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * 动态规划 + 哈希表
 */
public class jianzhi48 {
    public int lengthOfLongestSubstring(String s){
        Map<Character,Integer> dic = new HashMap<>();
        int res = 0 , tmp = 0;
        for(int j = 0;j<s.length();j++){
            //获取索引i
            int i = dic.getOrDefault(s.charAt(j),-1);
            dic.put(s.charAt(j),j);//更新哈希表
            //dp[j-1] -> dp[j]
            tmp = tmp<(j-i)?(tmp+1):(j-i);
            res = Math.max(res,tmp);
        }
        return res;
    }
}
