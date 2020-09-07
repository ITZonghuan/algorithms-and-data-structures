package math;

public class leet367平方数 {
    public static void main(String[] args) {
        System.out.println(isPerfectAquare(1));
    }
    public static boolean isPerfectAquare(int num){
        int subSum = 1;
        while(num > 0){
            num -= subSum;
            subSum += 2;
        }
        return num == 0;
    }
}
