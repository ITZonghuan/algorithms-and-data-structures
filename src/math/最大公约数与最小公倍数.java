package math;

public class 最大公约数与最小公倍数 {
    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }

    //最小公倍数为两数乘积除以最大公约数
    public int lcm(int a,int b){
        return a*b/gcd(a,b);
    }
}
