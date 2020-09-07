package bit_operation;

public class leet190翻转一个数的比特位 {
    public int reverseBits(int n){
        int ret = 0;
        for(int i=0;i<32;i++){
            ret <<= 1;
            ret |= (n & 1);
            //无符号右移
            n >>>= 1;
        }
        return ret;
    }
}
