package math;

public class 使用位操作和减法求解最大公约数 {
    public static void main(String[] args) {
        System.out.println(gcd(264,789));
    }
    private static int gcd(int a,int b){
        if(a<b){
            return gcd(b,a);
        }
        if(b == 0){
            return a;
        }
        boolean isAEven = isEven(a),isBEven = isEven(b);
        if(isAEven && isBEven){
            return 2*gcd(a>>1,b>>1);
        }else if(isAEven && !isAEven){
            return gcd(a>>1,b);
        }else if(!isAEven && isBEven){
            return gcd(a,b>>1);
        }else{
            return gcd(b,a-b);
        }
    }
    private static boolean isEven(int a){
        return a % 2==0?true:false;
    }
}
