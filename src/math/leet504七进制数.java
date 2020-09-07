package math;

public class leet504七进制数 {
    public String convertToBase7(int num){
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean isNeagtive = num<0;
        if(isNeagtive){
            num = -num;
        }
        while(num>0){
            sb.append(num%7);
            num/=7;
        }
        String res = sb.reverse().toString();
        return isNeagtive?"-"+res:res;
    }

    //jdk自带的进制转换函数
    public String convertToBase(int num){
        return Integer.toString(num,7);
    }
}
