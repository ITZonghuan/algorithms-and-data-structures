package search.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leet39组合求和 {
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(),combinations,0,target,candidates);
        return combinations;
    }
    private void backtracking(List<Integer> tempCombination,List<List<Integer>> combination,
                              int start,int target,int[] candidates){
        if(target == 0){
            combination.add(new ArrayList<>(tempCombination));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i] <= target){
                tempCombination.add(candidates[i]);
                backtracking(tempCombination,combination,i,target-candidates[i],candidates);
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
}
