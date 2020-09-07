package Leetcode._0628;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * 有序哈希表
 */
public class jianzhi50 {
    public char firstUniqChar(String s){
        Map<Character,Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c:sc){
            dic.put(c,!dic.containsKey(c));
        }
        for(Map.Entry<Character,Boolean> d:dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
