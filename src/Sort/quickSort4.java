package Sort;

public class quickSort4 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,0,2,1,2,0,1,2,0,1,2,0,1};
        qSort(nums,0,nums.length-1);
        for(int i: nums){
            System.out.print(i + "、");
        }
    }

    //定义快排方法，输入是一个数组、起始索引和最后索引
    public static void qSort(int[] nums,int low,int high){
        //如果最后索引大于等于起始索引，那么直接返回
        if(high <= low) return;
        //定一个标志位，选择数组的起始索引元素，
        int standard = nums[low];
        //定义一个索引存储容器，存放起始索引
        int store = low;
        //循环从起始索引后一个开始
        for(int scan = low+1;scan<=high;scan++){
            //与标志位进行对比
            if(nums[scan] < standard){
                swap(nums,scan,++store);
            }
        }
        //交换存储容器索引，即比标志位小的最后一个元素与标志位元素交换
        swap(nums,store,low);
        //遍历
        qSort(nums,low,store-1);
        qSort(nums,store+1,high);
    }

    //定义一个交换数组两个元素位置的方法
    public static void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
