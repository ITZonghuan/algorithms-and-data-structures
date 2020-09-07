import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 字符串匹配，返回匹配到的第一个索引
 */
public class KMP {
    public static void main(String[] args) {
        int[] next = kmpNext("ABCDABD");
        //System.out.println("next = " + Arrays.toString(next));
        System.out.println(KMPSearch("ABCDABCDABD","ABCDABD"));
    }
    private static int KMPSearch(String s1,String s2){
        if(s1 == null) return -1;
        int[] next = kmpNext(s2);
        for(int i=0,j=0;i<s1.length();i++){
            while(j>0 && s1.charAt(i) != s2.charAt(j)){
                //i -= next[j-1];
                //j = 0;
                j = next[j - 1];
            }
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            if(j == s2.length()) return i-j+1;
        }
        return -1;
    }
    //子字符串的特殊标记
    private static int[] kmpNext(String dest){
        if(dest == null) return null;
        int[] next = new int[dest.length()];
        next[0] = 0;
        //起始值是i为1，j为0，i在前，一直走，j在后，i、j索引处值相同才走
        for(int i=1,j=0;i<dest.length();i++){
            while(j>0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            //i、j索引处值相同时，j自增
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
