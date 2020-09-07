package Leetcode._0630;

/**
 * 股票的最大利润
 * 动态规划
 */
public class jianzhi63 {
    public int maxProfit(int[] prices){
        int cost = Integer.MAX_VALUE,profit = 0;
        for(int price:prices){
            cost = Math.min(cost,price);
            profit = Math.max(profit,price - cost);
        }
        return profit;
    }
}
