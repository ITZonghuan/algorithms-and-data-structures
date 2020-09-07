package dp.字符串编辑;

/**
 * 动态规划做这个题目不好想
 * dp[i]表示，通过复制粘贴操作，得到 i 个字符，最少需要几步操作。
 * 假设找到的因子是 j ，那么需要的最小步骤就是 dp[j] + dp[i/j]，
 * 其中，dp[j]表示需要多少步生成这个因子，
 * dp[i/j]表示需要多少步基于这个因子得到 i。
 *
 * 递归也不好想 哈哈哈
 */
public class leet650复制粘贴字符 {
    public int minSteps(int n){
        int[] dp = new int[n+1];
        int h = (int)Math.sqrt(n);
        for(int i=2;i<=n;i++){
            dp[i] = i;
            for(int j=2;j<=h;j++){
                if(i % j == 0){
                    dp[i] = dp[j] + dp[i/j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
