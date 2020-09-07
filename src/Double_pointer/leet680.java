package Double_pointer;

public class leet680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
    public static boolean validPalindrome(String s){
        if(s==null) return true;
        //一个循环来遍历数组中首尾指针
        for(int i=0,j = s.length()-1;i<j;i++,j--){
            //判断，当出现一个不相等的字符串时，删除头或者尾字符后来判断是否为回文
            if(!(s.charAt(i) == s.charAt(j))){
                //i+1到j表示把i跳过，i到j-1表示把j跳过
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
        }
        return true;
    }
    //首先想到的就是要设置一个函数来判断从i到j的字符是否为回文字符串？
    public static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(!(s.charAt(i++) == s.charAt(j--))){
                return false;
            }
        }
        return true;
    }
}
