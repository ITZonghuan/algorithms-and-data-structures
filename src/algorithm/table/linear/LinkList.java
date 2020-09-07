package algorithm.table.linear;

import java.util.Iterator;

//单向链表
public class LinkList<T> implements Iterable<T>{
    //记录头节点
    private Node head;
    private int N;

    //节点类
    private class Node{
        //储存数据
        T item;
        //下一个节点
        Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }
    public LinkList(){
        //初始化头结点
        this.head = new Node(null,null);
        //初始化元素个数
        this.N = 0;
    }

    //清空链表
    public void clear(){
        this.head = null;
        this.N = 0;
    }

    //获取链表长度
    public int length(){
        return N;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取指定位置i处的元素
    public T get(int i){
        //通过循环依次往后找，找i次
        Node n = head.next;
        for(int index = 0;index<i;index++){
            n = n.next;
        }
        return n.item;
    }

    //向链表中添加元素t
    public void insert(T t){
        //找到当前链表中最后一个元素
        Node n = head;
        while(n.next != null){
            n=n.next;
        }
        //创建新节点，保存元素
        Node newNode = new Node(t,null);
        //让当前最后一个节点指向新节点
        n.next = newNode;
        //链表元素个数+1
        N++;
    }

    //向指定位置i处添加元素t
    public void insert(int i,T t){
        //找到i位置前的结点
        Node pre = head;
        for(int index = 0;index<i;index++){
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新结点，并且新结点需要指向原来i位置的结点
        Node newNode = new Node(t,curr);
        //原来i位置前的节点指向新节点
        pre.next = newNode;
        //元素的个数+1
        N++;
    }

    //删除指定位置i处的元素，并返回被删除的元素
    public T remove(int i){
        //找到i位置前的结点
        Node pre = head;
        for(int index = 0;index<i;index++){
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //原来i位置前的节点指向i位置后的结点
        pre.next = curr.next;
        //元素个数-1
        N--;
        //返回i位置处的值
        return curr.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t){
        //从头结点依次往下找，取出item与t比较
        Node n = head;
        for(int index = 0;n.next!=null;index++){
            n=n.next;
            if(n.item.equals(t)){
                return index;
            }
        }
        return -1;
    }

    //反转整个链表
    public void reverse(){
        //判断当前链表是否为空，如果为空，则借宿运行，否则调用重载的reverse方法
        if(isEmpty()){
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node curr){
        if(curr.next == null){
            head.next = curr;
            return curr;
        }
        //递归反转当前结点的下一个结点，返回值就是链表反转后，当前结点的上一个结点
        Node pre = reverse(curr.next);
        //让返回的结点的下一个结点变成当前结点
        pre.next = curr;
        //把当前结点的下一个结点变为null
        curr.next = null;
        return curr;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
