package algorithm.sortways.test;

public class TestFactorial {
    public static void main(String[] args) {
        long result = Factorial(100000);
        System.out.println(result);
    }
    public static long Factorial(int n){
        if(n == 1){
            return 1;
        }
        return n*Factorial(n-1);
    }
}
