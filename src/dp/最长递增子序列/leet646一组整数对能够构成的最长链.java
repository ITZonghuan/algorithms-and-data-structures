package dp.最长递增子序列;

import java.util.Arrays;

public class leet646一组整数对能够构成的最长链 {
    public int findLingestChain(int[][] pairs){
        if(pairs == null || pairs.length == 0){
            return 0;
        }
        //对二维数据排序，按照第一个数的大小排序
        Arrays.sort(pairs,(a,b) -> (a[0] - b[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        //两次for循环，针对构成的最长递增子序列
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<i;j++){
                //如果前面一组的尾巴小于后面一组的头
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < dp.length; i++) {
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }
}
