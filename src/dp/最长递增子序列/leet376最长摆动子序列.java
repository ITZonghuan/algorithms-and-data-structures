package dp.最长递增子序列;

/**
 * 摆动序列的解法很特殊 很特别 所以很好记
 */
public class leet376最长摆动子序列 {
    public int wiggleMaxLength(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        //把最初的元素初始化为1
        int up = 1,down = 1;
        //循环从第二个数开始
        for (int i = 1; i < nums.length; i++) {
            //当前数和前一个数进行比较
            if(nums[i] > nums[i-1]){
                up = down + 1;
            }else if(nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }
        return Math.max(up,down);
    }
}
