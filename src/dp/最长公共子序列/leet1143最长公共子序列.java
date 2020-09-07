package dp.最长公共子序列;

/**
 * 这个也比较好理解 就是考虑当前两个序列索引处值是否相等？
 * 然后分为两种情况。比较好懂
 */
public class leet1143最长公共子序列 {
    public int longestCommonSubsequence(String text1,String text2){
        int n1 = text1.length(),n2 = text2.length();
        //dp[i][j]表示字符串text1在索引i-1处 到 text2在索引j-1处 的公共子序列
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    //此处是这个最长公共子序列的核心，当前字符串1的i处和字符串2的j处不相等
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
