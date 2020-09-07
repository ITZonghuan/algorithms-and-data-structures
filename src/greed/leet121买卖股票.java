package greed;

public class leet121买卖股票 {
    public int maxProfit(int [] prices){
        int n = prices.length;
        if(n == 0) return 0;
        int lowPrice = prices[0];
        int max = 0;
        for(int i = 1;i<n;i++){
            if(prices[i] < lowPrice) lowPrice = prices[i];
            else max=Math.max(max,prices[i] - lowPrice);
        }
        return max;
    }
}
