package algorithm.table.test;

import algorithm.table.linear.LinkList;

public class LinkListTest2 {
    public static void main(String[] args) {
        //创建单向链表对象
        LinkList<String> s1 = new LinkList<>();
        //测试插入
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1,"jamans");
        System.out.println("插入元素后目前线性表中元素个数为：" + s1.length());

        for (String s : s1) {
            System.out.println(s);
        }

        System.out.println("----------------------------");

        s1.reverse();

        for (String s : s1) {
            System.out.println(s);
        }
    }
}
