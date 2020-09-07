package string;

public class leet9判断一个整数是否是回文数 {
    public boolean isPalindrome(int x){
        if(x<0 ||(x%10==0 && x!=0)){
            return false;
        }
        int reverseNumber = 0;
        while(x>reverseNumber){
            reverseNumber = reverseNumber*10 + x%10;
            x/=10;
        }
        return x == reverseNumber || x == reverseNumber/10;
    }
}
