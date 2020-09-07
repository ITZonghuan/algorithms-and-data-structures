package dp.股票交易;

import java.util.Map;

/**
 * 有交易费用的麦面股票只是在有冷冻期的基础上加上费用约束
 */
public class leet714需要交易费用的股票交易 {
    public int maxProfit(int[] prices,int fee){
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] s1 = new int[n];
        int[] sell = new int[n];
        int[] s2 = new int[n];
        buy[0] = s1[0] = -prices[0];
        sell[0] = s2[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(s2[i-1],sell[i-1])  - prices[i];
            s1[i] = Math.max(s1[i-1],buy[i-1]);
            //与只有冷冻期的相比只表现在卖股票是增加了费用
            sell[i] = Math.max(buy[i-1],s1[i-1]) + prices[i] - fee;
            s2[i] = Math.max(sell[i-1],s2[i-1]);
        }
        return Math.max(s2[n-1],sell[n-1]);
    }
}
