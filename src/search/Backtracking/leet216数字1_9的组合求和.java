package search.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leet216数字1_9的组合求和 {
    public List<List<Integer>> combinationSum3(int k,int n){
        List<List<Integer>> combination = new ArrayList<>();
        List<Integer> tempCombination = new ArrayList<>();
        backTracing(combination,tempCombination,0,k,n);
        return combination;
    }

    private void backTracing(List<List<Integer>> combination,List<Integer> tempCombination,int start,int k,int n){
        if(k == 0 && n==0){
            combination.add(new ArrayList<>(tempCombination));
            return;
        }
        if(k == 0 || n==0) return;
        for (int i = start; i < 10; i++) {
            tempCombination.add(i);
            backTracing(combination,tempCombination,i + 1,k-1,n-i);
            tempCombination.remove(tempCombination.size()-1);
        }
    }
}
