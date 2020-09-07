package dp.背包;
//w为当前背包的总体积
//N为背包装入的物品数量
//weights数组存储N个物品的重量
//values数组存储N个物品的价值
//dp[i][j]表示前i件物品体积不超过j的情况下能达到的最大价值
//转移方程为：
//dp[i][j] = max(dp[i-1][j],dp[i-1][j-w] + v)
public class 背包问题 {
    public int knapsack(int W,int N,int[] weights,int[] values){
        int[][] dp = new int[N+1][W+1];
        //第一层循环，就是循环每个背包。从1开始
        for(int i=1;i<=N;i++){
            //重量为weights[i-1],价值为values[i-1];
            int w = weights[i-1],v=values[i-1];
            //第二层循环，
            for(int j=1;j<=W;j++){
                if(j >= w){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w] + v);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
}
