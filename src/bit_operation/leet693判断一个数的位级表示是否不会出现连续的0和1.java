package bit_operation;

public class leet693判断一个数的位级表示是否不会出现连续的0和1 {
    public boolean hasAlternatingBits(int n){
        int res = (n ^ (n>>1));
        return (res & (res + 1)) == 0;
    }
}
