package test;

public class 最长递增子序列dp {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(subSequence(nums));
    }
    public static int subSequence(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j]){
                    max = Math.max(max,dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        int len = 1;
        for (int i = 0; i < dp.length; i++) {
            len = Math.max(len,dp[i]);
        }
        return len;
    }
}
