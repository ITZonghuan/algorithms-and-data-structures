package dp.分割整数;

/**
 * 分割整数构成字母字符串
 */
public class leet91分割整数构成字母字符串 {
    public int numDecodings(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        //dp[i]以1~i组成的字符串能够构成的字母组合
        int[] dp = new int[n+1];
        dp[0] = 1;
        //首先判断首个数字是否为0
        dp[1] = s.charAt(0) == '0'?0:1;
        //循环从第二个数字开始，到n结束，包含n
        for(int i=2;i<=n;i++){
            //第一个字符是i-1取出来
            int one = Integer.valueOf(s.substring(i-1,i));
            //判断第一个数字是否为0，不为0的话，dp[i] += dp[i-1];
            if(one != 0){
                dp[i] += dp[i-1];
            }
            //判断第二个数字是否为0，为0就不可能组成两位数
            if(s.charAt(i-2) == '0'){
                continue;
            }
            //第二个数是前两个数的组合
            int two = Integer.valueOf(s.substring(i-2,i));
            if(two <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
