package dp.字符串编辑;

/**
 * 可编辑的操作就是插入、删除以及替换
 */
public class leet72编辑距离 {
    public int minDistance(String word1,String word2){
        if(word1 == null || word2 == null) return 0;
        int m = word1.length(),n = word2.length();
        //二维数组dp[i][j]表示word1前i个和word2前j个的最少操作次数使之一样
        int[][] dp = new int[m+1][n+1];
        //字符串编辑操作的初始化非常关键
        for(int i=1;i<=m;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<=n;i++){
            dp[0][i] = i;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //分别代表替换、插入、删除操作
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
