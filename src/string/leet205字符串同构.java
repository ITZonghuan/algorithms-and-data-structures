package string;

public class leet205字符串同构 {
    public boolean isIsomorphic(String s,String t){
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for(int i=0;i<s.length();i++){
            char schar = s.charAt(i),tchar = t.charAt(i);
            if(preIndexOfs[schar] != preIndexOft[tchar]){
                return false;
            }
            preIndexOfs[schar] = i+1;
            preIndexOft[tchar] = i+1;
        }
        return true;
    }
}
