package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet451 {
    public static void main(String[] args) {
        String s = "eeeeee";
        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s){
        Map<Character,Integer> map = new HashMap<>();
        char[] cha = s.toCharArray();
        for(char ch:cha){
            //统计频次，都用map的getOrDefault方法
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for(char i: map.keySet()){
            int value = map.get(i);
            //仍然是桶排序思想
            if(buckets[value] == null) buckets[value] = new ArrayList();
            buckets[value].add(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length - 1;i>=0;i--){
            if(buckets[i] == null) continue;
            for(char c:buckets[i]){
                for(int j=0;j<i;j++){
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }
}
