package math;

public class leet462最少移动次数使数组元素相等 {
    public int minMoves2(int[] nums){
        int res = 0;
        quickSort(nums,0,nums.length-1);
        for(int num:nums){
            res += Math.abs(num-nums[nums.length/2]);
        }
        return res;
    }
    public static void quickSort(int[] nums,int low,int high){
        if(low >= high) return;
        int standard = nums[low];
        int store = low;
        for(int scan = low +1;scan<=high;scan++){
            if(nums[scan]<standard){
                swap(nums,scan,++store);
            }
        }
        swap(nums,low,store);
        quickSort(nums,low,store-1);
        quickSort(nums,store+1,high);
    }
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
