package algorithm.table.test;

import algorithm.table.linear.Stack;

public class BracketMatchTest {
    public static void main(String[] args) {
        String str = "jn(j)k(njnn)((nnk)nknk())";
        boolean isboolean = isMatch(str);
        System.out.println(str + "该字符串中括号是否匹配" + isboolean);
    }

    public static boolean isMatch(String str){
        //创建一个栈对象
        Stack<String> match = new Stack<String>();
        //遍历字符串
        for (int i = 0; i < str.length(); i++) {
            String newstr = str.charAt(i) + "";
            //判断是否为左括号，如果是，就存放在栈中
            if(newstr.equals("(")){
                match.press(newstr);
            }else if(newstr.equals(")")){
                String pop = match.pop();
                //如果不是，再判断是否为右括号，如果是，从栈中弹出一个左括号，判断是否为null
                if(pop == null){
                    return false;
                }
            }
        }
        //判断最后栈是否为空
        if(match.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
