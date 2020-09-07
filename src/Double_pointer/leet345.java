package Double_pointer;
/**
 * 字符串中收尾元音字符的交换
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet345 {
    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverse(str));
    }
    public static String reverse(String str){
        if(str == null) return null;
        Set<Character> set = new HashSet<> (Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] res = new char[str.length()];
        //头尾双指针
        int i = 0,j = str.length()-1;
        char[] ch = str.toCharArray();
        while(i<=j){
            char ci = ch[i];
            char cj = ch[j];
            if(!set.contains(ci)){
                res[i++] = ci;
            }else if(!set.contains(cj)){
                res[j--] = cj;
            }else{
                res[i++] = cj;
                res[j--] = ci;
            }
        }
        for (int i1 = 0; i1 < res.length; i1++) {
            System.out.println(res[i1]);
        }
        //字符数组可以直接通过String的构造函数变成String对象输出
        return new String(res);
        //res.toString()
     }
}
