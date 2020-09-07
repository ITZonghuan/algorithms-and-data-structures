package bisearch;

public class leet540有序数组Single_Element {
    public int singleNonDuplicate(int[] nums){
        int l = 0,h =nums.length-1;
        while(l < h){
            int mid = l + (h-l)/2;
            //保证每次mid都在偶数位
            if(mid % 2 == 1){
                mid--;
            }
            if(nums[mid] == nums[mid+1]){
                l = mid +2;
            }else{
                h = mid;
            }
        }
        return nums[h];
    }
}
