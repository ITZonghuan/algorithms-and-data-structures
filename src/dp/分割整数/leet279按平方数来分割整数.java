package dp.分割整数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet279按平方数来分割整数 {
    public static void main(String[] args) {
        System.out.println(generateSquareList(17).toString());
    }
    public int numSquares(int n){
        List<Integer> res = new ArrayList<>();
        res = generateSquareList(n);
        //第i个平方数和最小
        int[] dp = new int[n+1];
        //第一层for循环，从1到n，找到每个数的最少平方数组合
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            //第二层for循环，遍历平方数容器中的每一个值
            //并将k放进去，比较最小值
            for(int k:res){
                if(i-k<0) break;
                min = Math.min(min,dp[i-k] + 1);
            }
            //每一个i对应的最小数放在其中
            dp[i] = min;
        }
        return dp[n];
    }
    //按平方数来分配整数，需要创建一个生产平方数的函数
    private static List<Integer> generateSquareList(int n){
        //用List容器来装
        List<Integer> squareList = new ArrayList<>();
        int num = 1;
        int sum = 1;
        //每次加1、3、5、7等
        while(sum <= n){
            //容器中依次装入1、3、5、7...
            squareList.add(sum);
            num+=2;
            sum+=num;
        }
        return squareList;
    }
}
