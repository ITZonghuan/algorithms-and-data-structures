package bit_operation;

/**
 * 汉明距离
 * 可用按位异或运算 位级表示不同的用1，相同的为0
 */
public class leet461统计两个数的二进制表示有多少位不同 {
    public int hammingDistance(int x,int y){
        int z = x ^ y;
        int cnt = 0;
        while(z != 0){
            //或者使用z & (z-1) 去除表示最低的那一位
            //z = z & (z-1);cnt++;
            if((z & 1) == 1){
                cnt++;
            }
            //z的二进制表示向右移动一位
            z>>=1;
        }
        return cnt;
    }
}
