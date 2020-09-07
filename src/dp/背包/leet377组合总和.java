package dp.背包;

import java.util.Arrays;

/**
 * 涉及顺序的完全背包问题
 */
public class leet377组合总和 {
    public int combinationSum4(int[] nums,int target){
        //初始化条件判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //声明动态数组 容量一般都是给定容量+1
        int[] maximum = new int[target + 1];

        //初始化 一般都是第一个数为1或者true
        maximum[0] = 1;
        //涉及到顺序的完全背包问题，需要对物品进行排序
        Arrays.sort(nums);

        //完全背包核心的两层循环 都是正序 + 状态转移方程
        //涉及顺序的完全背包问题都是物品顺序在里层循环
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                maximum[i] += maximum[i - nums[j]];
            }
        }
        return maximum[target];
    }
}
