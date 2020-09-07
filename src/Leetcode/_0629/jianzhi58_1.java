package Leetcode._0629;

/**
 * 翻转单词顺序
 */
public class jianzhi58_1 {
    public String reverseWords(String s){
        s = s.trim();//删除收尾空格
        int j = s.length()-1,i=j;
        StringBuilder res = new StringBuilder();
        while(i>=0){
            //搜索首个空格
            while (i>=0 && s.charAt(i)!=' ') i--;
            res.append(s.substring(i+1,j+1) + " ");
            //跳过单词间空格
            while(i>=0 && s.charAt(i) == ' ') i--;
            j = i;//j指向下一个单词的尾字符
        }
        return res.toString().trim();
    }
}
