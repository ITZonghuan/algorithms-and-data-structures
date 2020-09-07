package divide;
/**
 * 分治思想算法题就是分而治之
 */

import java.util.LinkedList;
import java.util.List;

public class leet241为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String input){
        List<Integer> resList = new LinkedList<>();
        //原来字符串也是可以这样遍历的
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c == '+' || c=='-' || c=='*'){
                //分治思想的精髓，就是左右两边都计算好之后再进行运算
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int m:left){
                    for(int n:right){
                        switch (c){
                            case '+':
                                resList.add(m + n);
                                break;
                            case '-':
                                resList.add(m - n);
                                break;
                            case '*':
                                resList.add(m * n);
                                break;
                        }
                    }
                }
            }
        }
        if(resList.size() == 0){
            //Integer.valueOf(str)
            //Integer.valueOf()可以将基本类型int转换为包装类型Integer，
            // 或者将String转换成Integer，String如果为Null或""都会报错
            resList.add(Integer.valueOf(input));
        }
        return resList;
    }

}
