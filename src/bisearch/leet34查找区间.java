package bisearch;

/**
 * 这是一个经典题型 好好捉摸
 * 可以好好看看leetcode该题的解析 labuladong
 */
public class leet34查找区间 {
    public int[] searchRange(int[] nums,int target){
        int firstIndex = findFirst(nums,target);
        int lastIndex = findFirst(nums,target+1)-1;
        if(firstIndex >= nums.length || nums[firstIndex]!=target){
            return new int[]{-1,-1};
        }
        return new int []{firstIndex,Math.max(firstIndex,lastIndex)};
    }
    private int findFirst(int[] nums,int target){
        int l = 0,h = nums.length;
        while(l < h){
            int mid = l + (h - l)/2;
            if(nums[mid] >= target){
                h = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
