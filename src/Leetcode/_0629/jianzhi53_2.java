package Leetcode._0629;

/**
 * 0~n-1中缺失的数字
 * 二分法
 * 排序数组中的搜索问题，首先想到二分法解决！！！
 */
public class jianzhi53_2 {
    public int missingNumber(int [] nums){
        int i = 0,j=nums.length-1;
        while(i<=j){
            int m = (i + j)/2;
            if(nums[m] == m) i = m + 1;
            else j = m-1;
        }
        return i;
    }
}
