package bisearch;

public class leet153旋转数组的最小数字 {
    public int findMin(int[] nums){
        int l = 0,h =nums.length-1;
        while(l < h){
            int mid = l + (h-l)/2;
            //如果当前数字小于最后一个元素值，说明这个元素和最后一个元素一直处在一个有序数组中
            if(nums[mid] <= nums[h]){
                h = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[h];
    }
}
