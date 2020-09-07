package dp.最长递增子序列;

/**
 * dp 存储最长递增子序列的长度，
 * dp[n] 表示以 Sn 结尾的序列的最长递增子序列长度。
 * dp[n] = max{1， dp[i]+1 | Si < Sn && i < n}
 */
public class leet300最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        //dp[i]表示从0到索引i处的数字中最大的递增子序列数
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            //第二个循环从0~i
            for (int j = 0; j < i; j++) {
                //如果当前的数小于dp[i]，进行比较一次
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
