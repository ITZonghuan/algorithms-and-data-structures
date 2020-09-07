package dp.背包;

/**
 * 上面的伪代码中两层for循环的次序可以颠倒。
 * 这个结论有可能会带来算法时间常数上的优化。
 */
public class 背包问题九讲 {
    public void pack(int[] nums){
        //0-1背包 需要倒序枚举
        //f[i][j]=max(f[i−1][j],f[i−1][j−w[i]]+v[i])

        //完全背包 需要正序枚举
        //f[i][j]=max(f[i−1][j],f[i][j−w[i]]+v[i])
//        for (int i = 1; i <= n; i++)
//            for (int j = w[i]; j <= V; j++)
//                f[j] = max(f[j], f[j - w[i]] + v[i]);
    }
}
