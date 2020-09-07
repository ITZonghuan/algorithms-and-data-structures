package Leetcode.first_day;

/**
 * 二进制中1的个数
 */
public class jianzhi15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }
    public static int hammingWeight(int n){
        int res = 0;
        while(n!=0){
            res+=n&1;
            n >>>= 1;
        }
        return res;
    }
}
