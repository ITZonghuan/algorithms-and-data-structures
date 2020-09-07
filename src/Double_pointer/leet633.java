package Double_pointer;

/**
 * 判断一个非负整数是否为两个整数的平方和
 */
public class leet633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));
    }
    public static boolean judgeSquareSum(int c){
        if(c < 0) return false;
        //头尾双指针
        int i=0,j = (int)Math.sqrt(c);
        //判断条件为什么是i<=j?因为可以是重复的一个数两次平方和
        while(i<=j){
            int SquareSum = i*i + j*j;
            if(SquareSum == c){
                return true;
            }else if(SquareSum < c){
                i++;
            }else{
                j--;
            }
        }
        return false;

    }
}
