package dp.股票交易;

/**
 * 需要冷却期的股票交易，就是画图，看当前节点的箭头指向
 */
public class leet309需要冷却期的股票交易 {
    public int maxProfit(int[] price){
        if(price == null || price.length == 0) return 0;
        int n = price.length;
        //定义四个一维数组，分别代表买、卖、持股期、不持股期
        int[] buy = new int[n];
        int[] s1 = new int[n];
        int[] sell = new int[n];
        int[] s2 = new int[n];
        //初始化：买和持股期的初始值为第一天价格的负数
        //卖和不持股的初始值为0
        buy[0] = s1[0] = -price[0];
        sell[0] = s2[0] = 0;
        for (int i = 1; i < price.length; i++) {
            //根据循环图，买的状态进来只有一种，不持股-> 买
            buy[i] = s2[i-1] - price[i];
            //持股状态，进来的有两种，持股和买股票 -> 持股，取最大值
            s1[i] = Math.max(s1[i-1],buy[i-1]);
            sell[i] = Math.max(buy[i-1],s1[i-1]) + price[i];
            s2[i] = Math.max(sell[i-1],s2[i-1]);
        }
        //返回的最大值，在不持股和卖股票期选一个最大的
        return Math.max(s2[n-1],sell[n-1]);
    }
}
