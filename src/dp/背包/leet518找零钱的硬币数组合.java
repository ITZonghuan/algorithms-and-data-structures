package dp.背包;

/**
 * 完全背包问题
 */
public class leet518找零钱的硬币数组合 {
    public int change(int amount,int[] coins){
        if(coins == null) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        //完全背包问题，正序循环
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                //前一个循环的dp[i]总数加上当前放入coin的总和
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
