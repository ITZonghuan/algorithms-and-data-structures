package bit_operation;

import java.util.HashMap;
import java.util.Map;

public class leet190颠倒二进制位之被调用很多次 {
    private static Map<Byte,Integer> map = new HashMap();
    public int reverseBits(int n){
        int ret = 0;
        for(int i=0;i<4;i++){
            ret <<= 8;
            ret |= reverseByte((byte)(n & 0b11111111));
            n >>>= 8;
        }
        return ret;
    }
    private Integer reverseByte(Byte n){
        if(map.containsKey(n)) return map.get(n);
        int res = 0;
        int t = n;
        for(int i=0;i<8;i++){
            res <<= 1;
            res |= (t & 1);
            t >>= 1;
        }
        map.put(n,res);
        return res;
    }
}
