package algorithm.table.test;

import algorithm.table.linear.TwoWayLinkList;

public class TwoWayLinkListTest {
    public static void main(String[] args) {
        //创建双向链表对象
        TwoWayLinkList<String> s1 = new TwoWayLinkList<>();
        //测试插入
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1,"jamans");
        System.out.println("插入元素后目前线性表中元素个数为：" + s1.length());

        for (String s : s1) {
            System.out.println(s);
        }

        System.out.println("-------------------------------------");
        //测试获取
        String getResult = s1.get(1);
        String getResult2 = s1.get(2);
        System.out.println("获取索引1处的结果为：" + getResult);
        System.out.println("获取索引2处的结果为：" + getResult2);
        //测试删除
        String removeResult = s1.remove(0);
        System.out.println("删除的元素是：" + removeResult);
        System.out.println("删除元素后目前线性表中元素个数为：" + s1.length());

        System.out.println("--------------------------------------------");
        System.out.println("第一个元素是：" + s1.getFirst());
        System.out.println("最后一个元素是：" + s1.getLast());

        //测试清空
        s1.clear();
        s1.isEmpty();
        System.out.println("清空后目前线性表中元素个数为：" + s1.length());
    }
}
