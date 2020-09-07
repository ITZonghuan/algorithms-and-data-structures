package Leetcode.first_day;

/**
 * 青蛙跳台阶
 */

public class jianzhi10_2 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("跳" + n + "级台阶，有" + numWays(n) + "种走法");
    }
    public static int numWays(int n){
        int a =1 ,b = 1 ,sum; //与斐波拉契数列唯一不同的地方
        for(int i =0;i<n;i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
