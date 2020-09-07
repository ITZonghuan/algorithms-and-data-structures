package Leetcode.first_day;

/**
 * 把字符串中的每个空格替换成“%20”
 */
public class jianzhi05 {
    public String replaceApace(String s){
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(c == ' '){
                res.append("%20");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
