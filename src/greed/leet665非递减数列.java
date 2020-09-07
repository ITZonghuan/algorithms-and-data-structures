package greed;

public class leet665非递减数列 {
    public boolean checkPossibility(int[] nums){
        if(nums == null) return false;
        int cnt = 0;
        //循环中带有修改条件不能大于2次，从索引1处开始
        for(int i =1;i<nums.length && cnt <2;i++){
            if(nums[i] >= nums[i-1]){
                continue;
            }
            cnt++;
            if(i-2>=0 && nums[i-2] >= nums[i]){
                nums[i] = nums[i-1];
            }else{
                nums[i-1] = nums[i];
            }
        }
        return cnt<=1;
    }
}
