package Leetcode._0629;

/**
 * 左旋转字符串
 * 除了切片函数之外的
 * 求余 + 字符串拼接
 */
public class jianzhi58_2 {
    public String reverseLeftWords(String s,int n){
        StringBuilder res = new StringBuilder();
        for(int i=n;i<n+s.length();i++){
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}
