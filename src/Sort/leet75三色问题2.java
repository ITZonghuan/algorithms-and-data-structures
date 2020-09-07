package Sort;

public class leet75三色问题2 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,0,2,1,2,0,1,2,0,1,2,0,1};
        sort(nums,0,nums.length-1);
        for(int i: nums){
            System.out.print(i + "、");
        }
    }
    public static void sort(int[] nums,int low,int high){
        int head = -1,scan = 0,tail = high+1;
        while(scan < tail){
            if(nums[scan] == 0){
                swap(nums,++head,scan++);
            }else if(nums[scan] == 2){
                swap(nums,--tail,scan);
            }else{
                scan++;
            }
        }
    }

    public static void swap(int[] nums,int index1, int index2){
        int temp = nums[index1];
        nums[index1]= nums[index2];
        nums[index2] = temp;
    }
}
