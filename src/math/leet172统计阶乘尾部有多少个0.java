package math;

public class leet172统计阶乘尾部有多少个0 {
    public int trailingZeroes(int n){
        int count =0;
        while(n>0){
            n/=5;
            count+=n;
        }
        return count;
    }
}
