package search.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leet131分隔字符串使得每个部分都是回文数 {
    public List<List<String>> partition(String s){
        List<List<String>> partitions = new ArrayList<>();
        List<String> tempPartition = new ArrayList<>();
        doPartiton(s,partitions,tempPartition);
        return partitions;
    }
    private void doPartiton(String s,List<List<String>> partions,List<String> tempPartition){
        if(s.length() == 0){
            partions.add(new ArrayList<>(tempPartition));
            return;
        }
        for(int i =0;i<s.length();i++){
            if(isPalindrom(s,0,i)){
                tempPartition.add(s.substring(0,i+1));
                doPartiton(s.substring(i+1),partions,tempPartition);
                tempPartition.remove(tempPartition.size() - 1);
            }
        }
    }
    private boolean isPalindrom(String s,int begin,int end){
        while(begin < end){
            if(s.charAt(begin++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
