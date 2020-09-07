package Leetcode._0629;

/**
 * 在排序数组中查找数字
 * 二分法
 */
public class jianzhi53_1 {
    public int search(int[] nums,int target){
        return helper(nums,target) - helper(nums,target-1);
    }
    int helper(int [] nums,int tar){
        int i = 0,j=nums.length-1;
        while(i<=j){
            int m = (i + j)/2;
            if(nums[m]<=tar) i = m+1;
            else j = m-1;
        }
        return i;
    }
}
