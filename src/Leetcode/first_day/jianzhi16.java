package Leetcode.first_day;

/**
 * 数值的整数次方
 * 不能使用库函数来实现一个小数的整数次幂运算
 */
public class jianzhi16 {
    public double myPow(double x,int n){
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0){
            x = 1/x;
            b = -b;
        }
        //巧妙使用二进制的位运算来实现幂运算
        while(b>0){
            if((b&1)==1) res *=x;
            x*=x;
            b>>=1;
        }
        return res;
    }
}
