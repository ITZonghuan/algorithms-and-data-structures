package Leetcode._0628;

/**
 * 礼物的最大价值
 */
public class jianzhi47 {
    public int maxValue(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i-1][j-1]时的最大价值
        int[][] dp = new int[row+1][col+1];
        for(int i =1;i<=row;i++){
            for(int j = 1;j<=col;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[row][col];
    }
}
