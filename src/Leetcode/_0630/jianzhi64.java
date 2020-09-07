package Leetcode._0630;

/**
 * 求1+2+...+n
 * 不能使用常见的解法，如乘除法、for、while等
 * 可用递归法 + 逻辑运算
 */
public class jianzhi64 {
    public int sumNums(int n){
        boolean x = n>1 && (n += sumNums(n-1)) >0;
        return n;
    }
}
