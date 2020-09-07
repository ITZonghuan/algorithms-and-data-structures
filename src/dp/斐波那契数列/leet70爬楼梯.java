package dp.斐波那契数列;

/**
 * 状态量：dp[i] = dp[i-1] + dp[i-2]
 */
public class leet70爬楼梯 {
    public int climbStairs(int n){
        if(n <= 2){
            return n;
        }
        int per1 = 1,per2 = 2;
        for(int i=2;i<n;i++){
            int cur = per1 + per2;
            per1 = per2;
            per2 = cur;
        }
        return per1;
    }
}
