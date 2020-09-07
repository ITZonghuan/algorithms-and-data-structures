package Sort;

public class quickSort2 {
    public static void main(String[] args) {
        int[] nums = {1,6,5,8,4,2,3,9,8,7,4,5,1,2,2,6};
        quickSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.print(i + "、");
        }
    }
    public static void quickSort(int[] nums,int low, int high){
        if(low < high){
            int index = getIndex(nums,low,high);
            quickSort(nums,low,index-1);
            quickSort(nums,index+1,high);
        }
    }

    public static int getIndex(int[] nums,int low,int high ){
        int temp = nums[low];
        while(low < high){
            while(low < high && nums[high] >= temp){
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low]<= temp){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
}
