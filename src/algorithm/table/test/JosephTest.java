package algorithm.table.test;

public class JosephTest {
    public static void main(String[] args) {
        //解决约瑟夫问题
        //1.构建循环链表，包含41个结点
        //用来记录第一个结点
        Node<Integer> first = null;
        //用来记录前一个结点
        Node<Integer> pre = null;
        for(int i = 1;i<=41;i++){
            //如果是第一个结点
            if(i == 1){
                first = new Node<Integer>(i,null);
                pre = first;
                continue;
            }
            //如果不是第一个结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            //如果是最后一个结点，需要让最后一个结点的下一个结点变为first
            if(i == 41){
                pre.next = first;
            }
        }
        //2.需要count计数器，模拟报数
        int count = 0;
        //3.遍历循环链表
        //记录每次拿到的结点，默认从首结点开始
        Node<Integer> n = first;
        Node<Integer> before = null;
        while(n.next != n){
            //模拟报数
            count++;
            //判断当前报数是否为3
            if(count == 3){
                //如果是3，把当前结点删除，打印当前结点，重置count++，让当前结点n后移
                before.next = n.next;
                System.out.print(n.item +",");
                count = 0;
                n=n.next;
            }else{
                //如果不是3，让before变为当前结点，让当前结点后移
                before = n;
                n = n.next;
            }
        }

        //打印最后一个元素
        System.out.print("最后一个元素为：" + n.item);
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
