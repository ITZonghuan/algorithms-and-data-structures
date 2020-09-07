package algorithm.table.test;


public class CircleListCheckTest {
    public static void main(String[] args) throws Exception{
        //创建结点
        Node<String> first = new Node<String>("aa",null);
        Node<String> second = new Node<String>("bb",null);
        Node<String> third = new Node<String>("cc",null);
        Node<String> forth = new Node<String>("dd",null);
        Node<String> fifth = new Node<String>("ee",null);
        Node<String> sixth = new Node<String>("ff",null);
        Node<String> sevevth = new Node<String>("gg",null);
        Node<String> eigth = new Node<String>("hh",null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = sevevth;
        sevevth.next = eigth;
        //产生闭环
        eigth.next = sixth;

        //判断是否有环
        //boolean circle = isCircle(first);
        //System.out.println("first链表中是否有环：" + circle);

        //判断环的入口
        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素是：" + entrance.item);

    }

    public static Node getEntrance(Node<String> first){
        //定义快慢指针和临时指针
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;

        //使用两个指针遍历链表
        // 遍历链表，先找到环（快慢指针相遇），准备一个临时指针，指向链表的首结点，继续遍历，直到慢指针与临时指针相遇，
        //        // 那么相遇时所指向的结点就是环的入口
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //判断快慢指针是否相遇
            if(fast.equals(slow) && temp == null){
                temp = first;
                continue;
            }
            //让临时结点变换
            if(temp != null){
                temp = temp.next;
                //判断临时指针是否和慢指针相遇
                if(temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
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
