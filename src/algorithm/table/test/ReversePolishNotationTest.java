package algorithm.table.test;


import algorithm.table.linear.Stack;

public class ReversePolishNotationTest {
    public static void main(String[] args) {
        //中缀表达式 3*（17-15） + 18/6 的逆波兰表达式如下
        String[] notation = {"3","17","15","-","*","18","6","/","+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    /**
     * @param notation 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    public static int calculate(String [] notation){
        //定义一个栈类，存放操作数
        Stack<Integer> cal = new Stack<>();
        //遍历字符串，判断是否为运算符
        for (int i = 0; i < notation.length; i++) {
            String str = notation[i];
            Integer a;
            Integer b;
            Integer result;
            switch(str){
                //如果是运算符，需要从栈中取出两个操作数，并进行运算，结果存回栈中
                case "+":
                    b = cal.pop();
                    a = cal.pop();
                    result = a + b;
                    cal.press(result);
                    break;
                case "-":
                    b = cal.pop();
                    a = cal.pop();
                    result = a - b;
                    cal.press(result);
                    break;
                case "*":
                    b = cal.pop();
                    a = cal.pop();
                    result = a * b;
                    cal.press(result);
                    break;
                case "/":
                    b = cal.pop();
                    a = cal.pop();
                    result = a / b;
                    cal.press(result);
                    break;
                    //如果是操作数，存放到栈中
                default:
                    cal.press(Integer.parseInt(str));
                    break;
            }
        }
        //最后返回计算结果
        int result = cal.pop();
        return result;
    }
}
