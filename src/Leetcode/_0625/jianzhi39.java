package Leetcode._0625;

/**
 * 数组中出现次数超过一半的数字
 */
public class jianzhi39 {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(arr));
    }
    public static int majorityElement(int[] nums){
        //众数为x,votes为票数
        int x = 0,votes = 0,count = 0;
        for(int num:nums){
            if(votes == 0) x = num;
            votes += (num ==x?1:-1);
        }
        //验证x是否为众数
        for(int num:nums){
            if(num == x) count ++;
        }
        return count>nums.length/2?x:0;//当无众数时返回0
    }
}
