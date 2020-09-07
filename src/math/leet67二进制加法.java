package math;

public class leet67二进制加法 {
    public static void main(String[] args) {
        String a = "011";
        int b =a.charAt(0);
        System.out.println(b);
    }
    public String addBinary(String a,String b){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i =a.length()-1,j=b.length()-1;i>=0 || j>=0;i--,j--){
            int sum = carry;
            sum+=(i>=0?a.charAt(i) - '0':0);//这样做是判断是否已经遍历完，看两个字符串哪个更长，短的补0
            sum+=(j>=0?b.charAt(j) - '0':0);//减'0'是因为'0'的值并不是0,而是48
            sb.append(sum%2);
            carry=sum/2;
        }
        sb.append(carry>0?carry:"");
        return sb.reverse().toString();
    }
}
