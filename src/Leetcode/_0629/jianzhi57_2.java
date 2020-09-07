package Leetcode._0629;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 */
public class jianzhi57_2 {
    public int[][] findContinuousSequence(int target){
        int i = 1;//滑动窗口的左边界
        int j = 1;//滑动窗口的右边界+1
        int sum = 0; //滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while(i<=target/2){
            if(sum<target){
                //右边界向右移动
                sum +=j;
                j++;
            }else if(sum > target){
                //左边界向右移动
                sum-=i;
                i++;
            }else{
                //记录结果
                int [] arr = new int[j-i];
                for(int k=i;k<j;k++){
                    arr[k-i] = k;
                }
                res.add(arr);
                //左边界向右移动
                sum-=i;
                i+=2;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
