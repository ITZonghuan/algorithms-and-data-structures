package search.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leet46排列 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList,permutes,hasVisited,nums);
        return permutes;
    }
    private void backtracking(List<Integer> permuteList,List<List<Integer>> permutes,boolean[] visited,int[] nums){
        //终止条件判断
        if(permuteList.size() == nums.length){
            permutes.add(new ArrayList<>(permuteList));
            return;
        }
        //判断 + 访问标记 + 增 + 回溯 + 减
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList,permutes,visited,nums);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
}
