package bit_operation;

public class 不用额外变量交换两个整数 {
    public static void main(String[] args) {
        int[] res = swap(2,3);
        for(int n:res){
            System.out.print(n + "、");
        }
    }
    public static int[] swap(int a,int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[]{a,b};
    }
}
