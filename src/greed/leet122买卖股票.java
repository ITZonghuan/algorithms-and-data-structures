package greed;

public class leet122买卖股票 {
    public int maxProfit(int[] prices){
        if(prices == null) return 0;
        int profit = 0;
        for(int i = 0;i<prices.length-1;i++){
            if(prices[i]< prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
}
