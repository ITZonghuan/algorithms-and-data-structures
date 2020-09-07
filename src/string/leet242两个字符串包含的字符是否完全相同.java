package string;

public class leet242两个字符串包含的字符是否完全相同 {
    public boolean isAnagram(String s,String t){
        int[] counts = new int[26];
        for(char c:s.toCharArray()){
            counts[c - 'a']++;
        }
        for(char c:t.toCharArray()){
            counts[c - 'a']--;
        }
        for(int i:counts){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
