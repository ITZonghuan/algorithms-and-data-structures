package search.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet40含有相同元素的组合求和 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> combinations = combinationSum2(candidates,8);
        System.out.println(combinations.toString());
    }
    public static List<List<Integer>> combinationSum2(int[] candidates,int target){
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(),combinations,new boolean[candidates.length],0,target,candidates);
        return combinations;
    }
    private static void backtracking(List<Integer> tempCombination,List<List<Integer>> combination,
                              boolean[] hasVisited,int start,int target,int[] candidates){
        if(target == 0){
            combination.add(new ArrayList<>(tempCombination));
            return;
        }
        for (int i = start; i < hasVisited.length; i++) {
            //如果两个数字相同 如果前面一个数字不在同一种情况中被访问，那么相等的数字只能访问一次
            if(i != 0 && candidates[i] == candidates[i-1] && !hasVisited[i-1]){
                continue;
            }
            if(candidates[i] <= target){
                tempCombination.add(candidates[i]);
                hasVisited[i] = true;
                backtracking(tempCombination,combination,hasVisited,i+1,target-candidates[i],candidates);
                hasVisited[i] = false;
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
}
