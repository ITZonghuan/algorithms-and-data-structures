package math;

public class leet326三的n次方 {
    public static void main(String[] args) {
        //System.out.println(isPowerOfTwo(7));
        //System.out.println(isPowerOfFour(2));
        System.out.println(isPowerOfThree(26));
    }
    public static  boolean isPowerOfTwo(int n){
        if(n<=0) return false;
        return (n & (n-1))==0;
    }
    public static boolean isPowerOfThree(int n){
        if(n<=0) return false;
        int maxNum = (int)Math.pow(3,(int)(Math.log(0x7fffffff)/Math.log(3)));
        return maxNum % n == 0;
    }
    public static boolean isPowerOfFour(int n){
        if(n<=0) return false;
        return (n & (n-1))==0 && ((n & 0x55555555) == 0);
    }
}
