package math;

import java.util.Arrays;

public class leet238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,1);
        int left = 1;
        for(int i=1;i<n;i++){
            left *= nums[i-1];
            res[i] *= left;
        }
        int right = 1;
        for(int j = n-2;j>=0;j--){
            right *= nums[j+1];
            res[j] *= right;
        }
        return res;
    }
}
