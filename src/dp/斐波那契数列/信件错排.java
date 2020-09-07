package dp.斐波那契数列;

/**
 * 问题描述：有 N 个信件和信箱，每封信件对应一个正确信箱位置。现在它们被打乱，求错误装信方式的数量。保证每一封信都装在错误的位置。
 * 假设第 i 个信装到第 j 个信封里面，
 * 而第 j 个信装到第 k 个信封里面。
 * 根据 i 和 k 是否相等，有两种情况：
 * dp[i] = (i-1)dp[i-1] + (i-1)dp[i-2]
 */
public class 信件错排 {
    public static void main(String[] args) {
        System.out.println(email(2));
    }
    public static int email(int n){
        if(n == 0 || n==1) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i =2;i<=n;i++){
            dp[i] = (i-1) * (dp[i-1] + dp[i-2]);
        }
        return dp[n];
    }
}
