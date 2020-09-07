package bit_operation;

/**
 * 两个相同的数异或结果为0
 * 所以找出那个不同的数直接对所有数进行异或操作
 */
public class leet136数组中唯一一个不重复的元素 {
    public int singleNumber(int[] nums){
        int res = 0;
        for(int n:nums){
            res = res ^ n;
        }
        return res;
    }
}
