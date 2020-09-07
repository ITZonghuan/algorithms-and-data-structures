package Double_pointer;

import java.util.List;

public class leet524 {
    public String findLongestWord(String s, List<String> d){
        String longestWord = "";
        for(String target:d){
            int l1 = longestWord.length(),l2 = target.length();
            //此判断是满足题目条件：最长子序列以及字典序最小
            //判断字典序最小，用str.compareTo(str2)方法
            if(l1 > l2 ||(l1 == l2 && longestWord.compareTo(target) < 0)){
                continue;
            }
            if(isSubstr(s,target)){
                longestWord = target;
            }
        }
        return longestWord;
    }
    // 定义一个函数，判断是否为子字符串
    public static boolean isSubstr(String s,String target){
        int i = 0,j = 0;
        //target是小字符串，s是大字符串
        while(i<s.length() && j<target.length()){
            //当找到两个字符相等时，小字符串后移动一位
            if(s.charAt(i) == target.charAt(j)){
                j++;
            }
            //不管是否相等，大字符串都后移一位
            i++;
        }
        return j == target.length();
    }
}
