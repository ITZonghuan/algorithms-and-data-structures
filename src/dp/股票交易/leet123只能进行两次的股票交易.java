package dp.股票交易;

/**
 * 只能进行两次的股票交易
 */
public class leet123只能进行两次的股票交易 {
    public int maxProfit(int[] prices){
        if(prices == null || prices.length == 0) return 0;
        //用四个状态量表示：firstBuy 和 secondBuy 初始值可以为Integer.MIN_VALUE
        //firstSell 和 secondSell 初始值为0
        int firstBuy = Integer.MIN_VALUE,firstSell = 0;
        int secondBuy = Integer.MIN_VALUE,secondSell = 0;
        //循环遍历，四个条件判断，也即四个状态转移
        for (int i = 0; i < prices.length; i++) {
            //当前买的状态 价值 低于当前的市场价
            if(firstBuy < -prices[i]){
                firstBuy = -prices[i];
            }
            if(firstSell < firstBuy + prices[i]){
                firstSell = firstBuy + prices[i];
            }
            if(secondBuy < firstSell - prices[i]){
                secondBuy = firstSell - prices[i];
            }
            if(secondSell < secondBuy + prices[i]){
                secondSell = secondBuy + prices[i];
            }
        }
        return secondSell;
    }
}
