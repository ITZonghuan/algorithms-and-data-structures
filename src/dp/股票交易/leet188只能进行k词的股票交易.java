package dp.股票交易;

/**
 * 只能进行k次的股票交易
 */
public class leet188只能进行k词的股票交易 {
    public int maxProfit(int k,int[] prices){
        int n = prices.length;
        //分为两种情况，第一种就是可交易的次数大于等于天数的一半
        if(k >= n/2){
            //这种情况，只用找到最大差值即可
            int maxProfit = 0;
            for(int i = 1;i<n;i++){
                if(prices[i] > prices[i-1]){
                    maxProfit += prices[i] - prices[i-1];
                }
            }
            return maxProfit;
        }
//        int[][][] dp = new int[n][k+1][2];
//        for (int i = 0; i < n; i++) {
//            for(int j = k;j>=1;j--){
//                if(i - 1 == -1){
//                    dp[i][j][0] = 0;
//                    dp[i][j][1] = -prices[0];
//                    continue;
//                }
//                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
//                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
//            }
//        }
//        return dp[n-1][k][0];

        //第二种情况就是交易次数小于天数的一半
        //定义一个三维矩阵，分别代表持股/不持股、可交易次数、第几天
        int[][][] dp = new int[2][k+1][n];
        for (int i = 0; i < n; i++) {
            //当前j代表还剩下多少交易次数
            for(int j = k;j>=1;j--){
                //初始化
                if(i  == 0){
                    //0代表不持股，初始值为0；1代表持股，初始值为-prices[0]
                    dp[0][j][i] = 0;
                    dp[1][j][i] = -prices[0];
                    continue;
                }
                //当前不持股状态最大值是 前一个不持股状态值  和  前一个持股卖股后的最大值，此时交易次数没有变化
                dp[0][j][i] = Math.max(dp[0][j][i-1],dp[1][j][i-1] + prices[i]);
                //当前持股状态的最大值是 前一个持股状态值 和 前一个不持股状态值买股之后的最大值，此时若买股，则次数减1
                dp[1][j][i] = Math.max(dp[1][j][i-1],dp[0][j-1][i-1] - prices[i]);
            }
        }
        //最后返回的是 不持股状态下，可交易次数是k次的条件下，最后一天的收益
        return dp[0][k][n-1];
    }
}
