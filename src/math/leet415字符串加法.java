package math;

public class leet415字符串加法 {
    public static void main(String[] args) {
        String num1 = "456825";
        String num2 = "5153151133";
        System.out.println(addString(num1,num2));
    }
    public static String addString(String num1,String num2){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i =num1.length()-1,j=num2.length()-1;i>=0 || j>=0;i--,j--){
            int sum = carry;
            sum += (i>=0?num1.charAt(i) - '0':0);
            sum += (j>=0?num2.charAt(j) - '0':0);
            sb.append(sum%10);
            carry = sum/10;
        }
        sb.append(carry>0?carry:"");
        return sb.reverse().toString();
    }
}
