package dp.背包;

/**
 * 可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
 * sum(P) - sum(N) = target
 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 * 2 * sum(P) = target + sum(nums)
 * 转换为：只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
 */
public class leet494改变一组数的正负号使得它们的和为一给定数 {
    public int findTargetSumWays(int[] nums,int S){
        int sum = computeArraySum(nums);
        //所有数的和相加都小于S 或者  (sum + S) 为奇数 都不存在
        if(sum < S || ((sum + S) & 1) ==1){
            return 0;
        }
        //背包大小为W = （sum + S）/2 的0-1背包问题
        int W = (sum + S)/2;
        int[] dp = new int[W+1];
        dp[0] = 1;
        for(int num : nums){
            //第二层循环 背包容量都是从大到小
            for(int i = W;i>=num;i--){
                dp[i] = dp[i] + dp[i-num];
            }
        }
        return dp[W];
    }
    private int computeArraySum(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
