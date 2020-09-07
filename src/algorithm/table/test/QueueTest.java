package algorithm.table.test;

import algorithm.table.linear.Queue;


public class QueueTest {
    public static void main(String[] args) {
        //创建一个队列对象
        Queue<String> q = new Queue<>();
        //测试队列的enqueue方法
        q.enqueue("aa");
        q.enqueue("bb");
        q.enqueue("cc");
        q.enqueue("dd");
        q.enqueue("ee");
        q.enqueue("ff");
        q.enqueue("gg");
        //测试队列的dequeue方法
        for (String s : q) {
            System.out.println(s);
        }
        System.out.println("---------------------------");
        String a = q.dequeue();
        System.out.println("出队列的对象是：" + a);
        System.out.println("剩余元素个数是：" + q.size());
    }
}
