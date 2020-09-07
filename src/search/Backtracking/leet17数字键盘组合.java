package search.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法一般解决排列组合问题
 */
public class leet17数字键盘组合 {
    private String[] KEYS = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        //储存结果的容器List
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        backTracing(new StringBuilder(),res,digits);
        return res;
    }
    private void backTracing(StringBuilder prefix,List<String> res,String digits){
        //递归终止条件：输入的数字长度等于目前匹配到的字符长度
        if(prefix.length() == digits.length()){
            res.add(prefix.toString());
            return;
        }
        //更新目前状态
        int curKey = digits.charAt(prefix.length()) - '0';
        String curString = KEYS[curKey];
        for(char c:curString.toCharArray()){
            //排列组合核心步骤一：增
            prefix.append(c);
            //排列组合核心步骤二：递归
            backTracing(prefix,res,digits);
            //排列组合核心步骤三：删/回溯
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
