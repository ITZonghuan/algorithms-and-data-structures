package greed;

import java.util.ArrayList;
import java.util.List;

public class leet763划分字母区间 {
    public List<Integer> partitionLabels(String s){
        if(s == null) return null;
        //找到每个字母的最后索引
        int[] LastIndex =new int[26];
        for(int i =0;i<s.length();i++){
            LastIndex[s.charAt(i) - 'a'] = i;
        }
        //声明一个边界和前面已经划分好的个数
        int boundary = 0,preSum = 0;
        List<Integer> list = new ArrayList<>();
        for(int j=0;j<s.length();j++){
            //更新边界
            boundary = Math.max(boundary,LastIndex[s.charAt(j) - 'a']);
            if(j == boundary){
                list.add(j+1-preSum);
                //前面已经划好边界的数
                preSum = j+1;
            }
        }
        return list;
    }
}
