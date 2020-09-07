package dp.分割整数;

public class leet91 {
    public int numDecodings(String s){
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] =  s.charAt(0)== '0' ? 0:1;
        for(int i=2;i<=n;i++){
            char one = s.charAt(i-1);
            //int onee = Integer.valueOf(s.charAt(i-1));
            if(one != '0'){
                dp[i] += dp[i-1];
            }
            if(s.charAt(i-2) == '0') continue;
            //Integer.parseInt() 返回由十进制参数表示的整数值,传入的是字符串
            int two = Integer.parseInt(s.substring(i-2,i));
            if(two <=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
