package string;

public class leet647回文子字符串个数 {
    private int count;
    public int countSubstrings(String s){
        for(int i=0;i<s.length();i++){
            extendSubstring(s,i,i);
            extendSubstring(s,i,i+1);
        }
        return count;
    }
    private void extendSubstring(String s,int start,int end){
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            count++;
        }
    }
}
