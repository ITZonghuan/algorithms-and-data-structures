package greed;

public class leet392判断子序列 {
    public boolean isSubsequence(String s,String t){
        int index = -1;
        //判断s是否为t的子字符串，将s变为字符数组
        for(char c:s.toCharArray()){
            /*
            str.indexOf(char c,int index)从指定索引index处开始搜索字符c；
            返回该字符第一次出现的索引，如果字符没有出现，范围-1
             */
            //判断字符串s中按顺序的每一个字符是否可以在字符串t中找到
            index = t.indexOf(c,index + 1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }
}
