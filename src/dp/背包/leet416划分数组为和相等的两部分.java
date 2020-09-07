package dp.背包;

/**
 * 这一题真不好理解！！！！
 * 可以看成一个背包大小为 sum/2 的 0-1 背包问题。
 */
public class leet416划分数组为和相等的两部分 {
    public boolean canPartition(int[] nums){
        int sum = computeArraySum(nums);
        if((sum & 1) == 1) return false;
        int W = sum/2;
        //背包大小变为W的0-1背包问题，即sum/2
        //dp[i]表示背包大小为i时能否装满背包，这样就好理解点了
        boolean[] dp = new boolean[W+1];
        dp[0] = true;
        for(int num:nums){
            for(int i = W;i>=num;i--){
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[W];
    }
    private int computeArraySum(int[] nums){
        int sum = 0;
        for(int num:nums){
            sum+= num;
        }
        return sum;
    }
}
