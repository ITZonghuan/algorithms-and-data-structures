package search.Backtracking;
/**
 * 只是在未重复的情况下多了一个排序和条件判断
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet47含有相同元素的全排列 {
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        Arrays.sort(nums); //数组自带的排序函数
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList,permutes,hasVisited,nums);
        return permutes;
    }
    private void backtracking(List<Integer> permuteList,List<List<Integer>> permutes,boolean[] visited,int[] nums){
        if(permuteList.size() == nums.length){
            permutes.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if(i != 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList,permutes,visited,nums);
            permuteList.remove(permuteList.size()-1);
            visited[i] = false;
        }
    }
}
