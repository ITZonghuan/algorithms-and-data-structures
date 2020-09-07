package Sort;

/**
 * 快排
 */
public class leet215_3 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4,2};
        System.out.println(findKthLargest(arr,2));
    }
    public static int findKthLargest(int[] nums,int k){
        int kIndex = nums.length - k;
        quickSort(nums,0,nums.length-1);
        return nums[kIndex];
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low < high){
            int index = getIndex(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }
    public static int getIndex(int[] arr,int low,int high){
        int temp = arr[low];
        while(low < high){
            while(low < high && arr[high]>=temp){
                high--;
            }
            arr[low] = arr[high];
            while(low < high && arr[low]<=temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
