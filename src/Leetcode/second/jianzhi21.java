package Leetcode.second;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class jianzhi21 {
    public int[] exchange(int[] nums){
        int i = 0,j = nums.length-1,temp;
        while(i<j){
            while((nums[i] & 1) == 1) i++;
            while((nums[j] & 1) == 0) j--;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] =temp;
        }
        return nums;
    }
}
