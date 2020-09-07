package search.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet90含有相同元素求子集 {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        for(int size = 0;size <= nums.length;size++){
            backtracking(0,tempSubset,subsets,hasVisited,size,nums);
        }
        return subsets;
    }
    private void backtracking(int start,List<Integer> tempSubset,List<List<Integer>> subsets,boolean[] hasVisited,int size,int[] nums){
        if(tempSubset.size() == size){
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }
        for(int i =start;i < nums.length;i++){
            if(i != 0 && nums[i] == nums[i-1] && !hasVisited[i-1]){
                continue;
            }
            tempSubset.add(nums[i]);
            hasVisited[i] = true;
            backtracking(i+1,tempSubset,subsets,hasVisited,size,nums);
            hasVisited[i] = false;
            tempSubset.remove(tempSubset.size() - 1);
        }
    }
}
