package Leetcode.second;

/**
 * 表示数值的字符串
 */
public class jianzhi20 {
    public boolean isNumber(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        //标记当前位置的前一个数是否遇到相应的情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for(int i = 0;i<str.length;i++){
            if(str[i] >= '0' && str[i]<='9'){
                numSeen = true;
            }else if(str[i] == '.'){
                //.之前不能出现.和e
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(str[i]=='e' || str[i]=='E'){
                //e之前不能出现e或者.
                if(eSeen || dotSeen){
                    return false;
                }
                eSeen = true;
                //下面这句话着实不懂,好像有点懂了，这个地方很巧妙！！！
                numSeen = false;//重置numSeen，排除123e或者123e+的情况，确保e之后也出现数
            }else if(str[i] =='-' ||str[i] == '+'){
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }else{//其他情况
                    return false;
                }
            }
        }
        return numSeen;
    }
}
