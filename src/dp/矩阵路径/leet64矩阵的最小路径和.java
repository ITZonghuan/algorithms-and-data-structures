package dp.矩阵路径;

/**
 * 矩阵的最短路径和，从左上角到右下角
 */
public class leet64矩阵的最小路径和 {
    public int minPathSum(int[][] grid){
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //两次for循环，因为是矩阵
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[0][0];
                }else if(j == 0){
                    //在第一列，只能从上到下
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else if(i == 0){
                    //在第一行，只能从左到右
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else{
                    //其他位置，就是讨论从左边过来和上面过来的最小值
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
