package bit_operation;

public class leet371实现整数的加法 {
    public int getSum(int a,int b){
        return b==0?a:getSum(a ^ b,(a & b)<<1);
    }
}
