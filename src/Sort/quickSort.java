package Sort;

public class quickSort {
    public static void main(String[] args) {
        int[] nums = {1,3,5,9,5,4,7,1,6,2,5,1};
        sort(nums,0,nums.length-1);
        for (int i:nums) {
            System.out.print(i + "、");
        }
    }
    public static void sort(int[] nums,int low,int high){
        if(low < high){
            int index = getIndex(nums,low,high);
            sort(nums,low,index - 1);
            sort(nums,index + 1,high);
        }
    }
    public static int getIndex(int[] nums,int low,int high){
        int temp = nums[low];
        while(low < high){
            while(low < high && nums[high] >= temp){  //均是要和temp进行比较
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low] <= temp){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
}
