package dp.斐波那契数列;

/**
 * 不能抢劫相邻近的住户
 * dp[i] = max(dp[i-1],dp[i-2] + nums[i])
 */
public class leet198强盗抢劫 {
    public int rob(int[] nums){
        int per1 = 0,per2 = 0;
        for(int i = 0;i<nums.length;i++){
            int cur = Math.max(per1 + nums[i],per2);
            per1 = per2;
            per2 = cur;
        }
        return per2;
    }
}
