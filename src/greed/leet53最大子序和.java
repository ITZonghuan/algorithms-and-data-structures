package greed;

public class leet53最大子序和 {
    public int maxSubArray(int[] nums){
        if(nums == null) return 0;
        //定义一个前数组和，初始化为数组第一个元素值
        int presum = nums[0];
        //定义一个最大和，初始化为前数组和
        int maxsum = presum;
        for(int i=1;i<nums.length;i++){
            presum = presum>=0?presum+nums[i]:nums[i];
            maxsum = Math.max(maxsum,presum);
        }
        return maxsum;
    }
}
