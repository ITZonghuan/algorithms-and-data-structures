package bit_operation;

public class leet338统计从0_n每个数的二进制表示中1的个数 {
    public int[] countBits(int num){
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i =1;i<=num;i++){
            if((i & 1) == 1){
                res[i] = res[i-1] + 1;
            }else{
                res[i] = res[i/2];
            }
        }
        return res;
    }

}
