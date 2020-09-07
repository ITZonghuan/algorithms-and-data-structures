package Leetcode.first_day;

/**
 * 判断一个数组是否有重复元素，并返回这个重复元素
 */
public class jianzhi03 {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
