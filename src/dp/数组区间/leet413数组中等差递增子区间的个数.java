package dp.数组区间;

/**
 * dp[i]表示以A[i]为结尾的等差递增子区间的个数
 */
public class leet413数组中等差递增子区间的个数 {
    public int numberOfArithmeticSlices(int[] A){
        if(A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for(int i=2;i<n;i++){
            //判断条件：如果递增，dp[i] = dp[i-1] + 1
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp[i] = dp[i-1] + 1;
            }
        }
        //递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回dp数据累加的结果

        int total = 0;
        for(int cnt:dp){
            total += cnt;
        }
        return total;
    }
}
