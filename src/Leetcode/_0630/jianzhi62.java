package Leetcode._0630;

import java.util.ArrayList;

/**
 * 圆圈中最后剩下的数字
 * 约瑟夫问题
 * 基于ArrayList的模拟链表实现
 * or 数学方法实现
 */
public class jianzhi62 {
    public int lastRemaining(int n,int m){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        int idx = 0;
        while(n>1){
            idx = (idx + m -1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
