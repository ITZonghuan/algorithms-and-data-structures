package math;

public class leet169数组中出现次数多于一半的元素 {
    public int majorityElement(int[] nums){
        int count = 0,majority = nums[0];
        for(int num:nums){
            majority = (count ==0?num:majority);
            count = (majority == num?count +1:count-1);
        }
        return majority;
    }
}
