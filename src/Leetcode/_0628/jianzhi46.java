package Leetcode._0628;

/**
 * 把数字翻译成字符串
 * 动态规划
 */
public class jianzhi46 {
    public int translateNum(int num){
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=s.length();i++){
            String temp = s.substring(i-2,i);
            if(temp.compareTo("10") >=0 && temp.compareTo("25")<=0){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
