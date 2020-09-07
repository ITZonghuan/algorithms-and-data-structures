package Leetcode._0630;

/**
 * 不用加减乘除做加法
 * 那就只能想到位运算了
 * 位运算知识 好好理解一下
 */
public class jianzhi65 {
    public int add(int a,int b){
        if(b == 0){
            return a;
        }
        //转换成非进位和+进位
        return add(a^b,(a&b)<<1);
    }
}
