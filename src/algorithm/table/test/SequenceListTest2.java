package algorithm.table.test;

import algorithm.table.linear.SequenceList;


public class SequenceListTest2 {
    public static void main(String[] args) {
        SequenceList<String> s1 = new SequenceList<String>(3);
        s1.insert("小明");
        s1.insert("小强");
        s1.insert("小芳");
        s1.insert("小王");
        for (String s : s1) {
            System.out.println(s);
        }
    }
}
