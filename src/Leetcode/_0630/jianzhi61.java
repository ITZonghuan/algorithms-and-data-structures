package Leetcode._0630;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 * set判重
 */
public class jianzhi61 {
    public boolean isStraight(int[] nums){
        Set<Integer> repeat = new HashSet<>();
        int max = 0,min = 14;
        for(int num:nums){
            if(num == 0) continue;//跳过大小王
            max = Math.max(max,num);//最大牌
            min = Math.min(min,num);//最小牌
            //若有重复，提前返回false
            if(repeat.contains(num)) return false;
            repeat.add(num);//添加此牌至Set
        }
        return max-min<5;//最大牌-最小牌<5 则可构成顺子
    }
}
