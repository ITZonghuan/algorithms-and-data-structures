package dp.背包;

/**
 * 完全背包问题
 */
public class leet322找零钱的最少硬币数 {
    public int coinChange(int[] coins,int amount){
        int[] dp = new int[amount + 1];
        for(int coin : coins){
            //将逆序遍历变为正序遍历
            //背包大小是面额大小
            for(int i = coin;i<=amount;i++){
                //第一种情况，背包大小就是coin
                if(i == coin){
                    dp[i] = 1;
                    //第二种情况，当前i没有方案 而且 i-coin 有方案
                }else if(dp[i] == 0 && dp[i - coin] != 0){
                    dp[i] = dp[i-coin] + 1;
                    //第三种情况，dp[i-coin] 有方案 且dp[i]有方案，进行比较
                }else if(dp[i-coin] != 0){
                    dp[i] = Math.min(dp[i],dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0?-1:dp[amount];
    }
}
