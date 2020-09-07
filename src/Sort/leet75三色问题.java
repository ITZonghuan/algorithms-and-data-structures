package Sort;

public class leet75三色问题 {
    public void sortColors(int[] nums){
        //双指针/三指针
        int zero = -1,one =0,two = nums.length;
        while(one<two){
            if(nums[one] == 0){
                swap(nums,++zero,one++);
            }else if(nums[one] == 2){
                swap(nums,--two,one);
            }else{
                ++one;
            }
        }
    }
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
