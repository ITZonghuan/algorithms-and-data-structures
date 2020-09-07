package dp.背包;

/**
 * 多维费用的01背包
 */
public class leet474_01字符构成最多的字符串 {
    public int findMaxForm(String[] strs,int m,int n){
        if(strs == null || strs.length == 0){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        //每个字符串只能用一次
        for(String s:strs){
            int ones = 0,zeros = 0;
            for(char c:s.toCharArray()){
                if(c == '0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
            //多维费用的0-1背包的两层循环，背包容量也是从大到小
            for(int i=m;i>=zeros;i--){
                for(int j = n;j>=ones;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeros][j-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
