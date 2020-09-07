package dp.分割整数;

public class leet343分割整数的最大乘积 {
    public static void main(String[] args) {
        System.out.println(integerBreak(6));
    }
    public static int integerBreak(int n){
        //默认初始化为0；
        int[] dp = new int[n+1];
        //System.out.println("dp[10] = " + dp[6]);
        dp[1] = 1;
        //两场for循环，第一层是从2开始到n
        //第二层循环是从1开始，寻找 j * dp[i-j],当前dp[i],和j * (i-j)三者中最大值
        for (int i = 2; i <= n; i++) {
            for(int j = 1;j<=i-1;j++){
                System.out.println("i=" + i);
                System.out.println("刚开始dp[i]=" + dp[i]);
                dp[i] = Math.max(dp[i],Math.max(j * dp[i-j],j * (i-j)));
                //dp[i] =Math.max(j * dp[i-j],j * (i-j));
                System.out.println("后来dp[i]=" + dp[i]);
            }
        }
        return dp[n];
    }
}
