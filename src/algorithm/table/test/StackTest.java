package algorithm.table.test;

import algorithm.table.linear.Stack;


public class StackTest {
    public static void main(String[] args) {
        //创建栈对象
        Stack<String> onestack = new Stack<String>();
        //测试压栈
        onestack.press("a");
        onestack.press("b");
        onestack.press("c");
        onestack.press("d");

        for (String s : onestack) {
            System.out.print(s + "、");
        }

        System.out.println("---------------------------------");
        //测试弹栈
        String result = onestack.pop();
        System.out.println("弹出的元素是:" + result);
        System.out.println("剩下的元素个数为：" + onestack.size());
    }
}
