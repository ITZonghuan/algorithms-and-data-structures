package Leetcode._0627;

/**
 * 连续子数组的最大和
 */
public class jianzhi42 {
    public int maxSubArray(int[] nums){
        int max = nums[0];
        int former = 0;//用于记录dp[i-1]的值，dp[-1]=0
        int cur = nums[0];//用于记录dp[i]的值
        for(int num:nums){
            cur = num;
            if(former>0) cur += former;
            if(cur>max) max = cur;
            former = cur;
        }
        return max;
    }
}
