package dp.数组区间;

/**
 * 给定数组区间：[-2, 0, 3, -5, 2, -1]
 * 求索引i~j的和 ,可以转换为sum[j+1] - sum[i]
 * dp[i] 表示从头到现在的总和
 */
public class leet303数组区间和 {
    class NumArray{
        private int[] sums;
        public NumArray(int[] nums){
            sums = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i-1] + nums[i-1];
            }
        }

        public int sumRange(int i,int j){
            return sums[j+1] - sums[i];
        }
    }
}
