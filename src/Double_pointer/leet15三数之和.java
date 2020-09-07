package Double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在一个数组中，是否可以找到三个数之后等于0;
 * 答案中不可以包含重复的三元组
 */
public class leet15三数之和 {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        //对数组进行排序
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            //如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;  //去重？
            int L = i+1;
            int R = len-1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; //去重
                    while (L<R && nums[R] == nums[R-1]) R--; //去重
                    L++;
                    R--;
                }else if(sum < 0){
                    L++;
                }else{
                    R--;
                }
            }
        }
        return ans;
    }
}
