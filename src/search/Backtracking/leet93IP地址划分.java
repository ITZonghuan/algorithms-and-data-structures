package search.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leet93IP地址划分 {
    public List<String> restoreIpAddresses(String s){
        List<String> res = new ArrayList();
        if(s == null || s.length() == 0) return res;
        doRestore(res,0,s,new StringBuilder());
        return res;
    }
    private void doRestore(List res,int Kth,String s,StringBuilder tempString){
        //递归终止条件
        if(Kth == 4 || s.length() == 0){
            if(Kth == 4 && s.length() == 0){
                res.add(tempString.toString());
            }
            return;
        }
        //改变目前状态
        for(int i=0;i<s.length() && i<=2;i++){
            if(i != 0 && s.charAt(0) == '0'){
                break;
            }
            String part = s.substring(0,i+1);
            if(Integer.parseInt(part) <=255){
                if(tempString.length() != 0){
                    part = "." + part;
                }
                //增-递归-回溯
                tempString.append(part);
                doRestore(res,Kth+1,s.substring(i+1),tempString);
                tempString.delete(tempString.length()-part.length(),tempString.length());
            }
        }
    }
}
