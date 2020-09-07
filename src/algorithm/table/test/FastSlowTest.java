package algorithm.table.test;


public class FastSlowTest {
    public static void main(String[] args) throws Exception{
        //创建结点
        Node<String> first = new Node<String>("aa",null);
        Node<String> second = new Node<String>("bb",null);
        Node<String> third = new Node<String>("cc",null);
        Node<String> forth = new Node<String>("dd",null);
        Node<String> fifth = new Node<String>("ee",null);
        Node<String> sixth = new Node<String>("ff",null);
        Node<String> sevevth = new Node<String>("gg",null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = sevevth;

        //查找中间值
        String mid = getMid(first);
        System.out.println("中间值为：" + mid);

    }

    public static String getMid(Node<String> first){
        //定义两个指针
        Node<String> fast = first;
        Node<String> slow = first;

        //使用两个指针遍历链表
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    //创建结点类
    private static class Node<T> {
        //储存数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
