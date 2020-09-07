package jianzhi_offer;

public class offer16 {
    public static void main(String[] args) {
        System.out.println(myPow(2.0,-2147483600));
        long k = -2147483648+1;
        System.out.println();
    }
    public static double myPow(double x,int n){
        if(x == 0) return 0;
        long m = n;
        double res = 1.0;
        if(n < 0){
            x = 1/x;
            m = -m;
        }
        while (m>0){
            if((m & 1) == 1) res *= x;
            x*=x;
            m = m>>1;
        }
        return res;
    }
}
