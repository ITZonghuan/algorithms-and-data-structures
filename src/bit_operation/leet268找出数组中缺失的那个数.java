package bit_operation;

public class leet268找出数组中缺失的那个数 {
    public int missingNumber(int[] nums){
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res = res ^ i ^ nums[i];
        }
        return res ^ nums.length;
    }
}
