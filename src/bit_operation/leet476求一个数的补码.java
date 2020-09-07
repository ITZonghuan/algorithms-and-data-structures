package bit_operation;
/*
5的二进制是：0101，7的二进制是： 0111，
它们的抑或为：0010，去掉前导零位即为取反。
再来一个例子，假设a为1110 0101，b为1111 1111，
a^b = 0001 1010是a的取反。
也就是说二进制位数与num相同，
且全为1的数tmp与num的抑或即为所求。

 */
public class leet476求一个数的补码 {
    public static void main(String[] args) {
        System.out.println(1<<1);
    }
    public int findComplement(int num){
        if(num == 0) return 1;
        int temp = 1<<30;
        while((num & temp) == 0) temp>>=1;
        temp = (temp << 1) - 1;
        return temp ^ num;
    }
}
