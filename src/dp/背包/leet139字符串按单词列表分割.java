package dp.背包;
/**
 * 涉及顺序的完全背包问题
 */

import java.util.List;

public class leet139字符串按单词列表分割 {
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            //物品的迭代应该放在最里层
            for(String word:wordDict){
                int len = word.length();
                if(len <= i && word.equals(s.substring(i-len,i))){
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
}
