package dp.矩阵路径;

import java.util.Arrays;

public class leet62矩阵的总路径数 {
    public int uniquePaths(int m,int n){
        int[][] dp = new int[m][n];
        //每个位置填入值1，第一列和第一行上位置的路径数都是1
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i],1);
        }
        //循环从[1][1]开始，当前路径总数始终等于左边路径数+上面路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
