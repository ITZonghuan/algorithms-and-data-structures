package bit_operation;

/**
 * 负数以补码形式存在，取反加1
 * num &= (-num) 得到最右侧不为0的位
 */
public class leet260数组中不重复的两个元素 {
    public static void main(String[] args) {
        int res = 6 & (-6);
        System.out.println(res);
    }
    public int[] singleNumber(int[] nums){
        int res = 0;
        //所有数进行异或操作，最后结果就是两个不同的数的异或结果
        for(int n:nums){
            res = res ^ n;
        }
        res &= (-res);
        //用一个容量为2的数组存放当前不同的两个值
        int[] ret = new int[2];
        for(int n:nums){
            if((n & res) == 0) ret[0] ^= n;
            else ret[1] ^= n;
        }
        return ret;
    }
}
