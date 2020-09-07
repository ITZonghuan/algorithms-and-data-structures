package string;

public class leet409最长回文串 {
    public int longestPalindrome(String s){
        //为啥是58个 因为A的阿斯克码是65，a的阿斯克码是97
        int[] couts = new int[58];
        for(char c:s.toCharArray()){
            couts[c-'A']++;
        }
        int length = 0;
        for(int i:couts){
            length+=i - (i&1);
        }
        return length<s.length()?length+1:length;
    }
}
