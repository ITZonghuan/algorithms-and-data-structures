package Sort;

public class quickSort3 {
    public static void main(String[] args) {
        int[] nums = {1,6,3,5,8,8,9,4,5,2,1,0,6};
        qSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.print(i +"、");
        }
    }
    public static void qSort(int[] nums,int low,int high){
        if(low >= high) return;
        int standard = nums[low];
        int store = low;
        for(int scan=low+1;scan<=high;scan++){
            if(nums[scan] < standard){
                swap(nums,++store,scan);
            }
        }
        swap(nums,low,store);
        qSort(nums,low,store-1);
        qSort(nums,store+1,high);
    }
    public static void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
