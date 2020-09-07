package Arrays;

public class leet485找出数组中最长的连续1 {
    public int findMaxConsecutiveOnes(int[] nums){
        int max = 0,cur = 0;
        for(int num:nums){
            cur = num==0?0:cur+1;
            max = Math.max(max,cur);
        }
        return max;
    }
}
