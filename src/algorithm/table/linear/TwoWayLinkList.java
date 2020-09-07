package algorithm.table.linear;

import java.util.Iterator;

//单向链表
public class TwoWayLinkList<T> implements Iterable<T>{
    //记录头节点
    private Node head;
    //记录尾节点
    private Node last;
    private int N;

    //结点类
    private class Node{
        //储存数据
        public T item;
        //指向下一个节点
        public Node next;
        //指向上一个结点
        public Node pre;

        public Node(T item, Node pre,Node next){
            this.item = item;
            this.next = next;
            this.pre = pre;
        }
    }
    public TwoWayLinkList(){
        //初始化头结点和尾结点
        this.head = new Node(null,null,null);
        this.last = null;
        //初始化元素个数
        this.N = 0;
    }

    //清空链表
    public void clear(){
        this.head.next = null;
        this.last = null;
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

    //获取第一个元素
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    //向链表中添加元素t
    public void insert(T t){
        if(isEmpty()){
            //如果链表为空
            //创建新结点
            Node newNode = new Node(t,head,null);
            //让新结点成为尾结点
            last = newNode;
            //让头结点指向尾结点
            head.next = last;
        }else{
            //如果链表不为空
            Node oldLast = last;
            //创建新结点
            Node newNode = new Node(t,oldLast,null);
            //让当前尾结点指向新结点
            oldLast.next = newNode;
            //让新结点成为尾结点
            last = newNode;
        }
        //链表元素个数+1
        N++;
    }

    //向指定位置i处添加元素t
    public void insert(int i,T t){
        //找到i位置前的结点
        Node pre = head;
        for(int index = 0;index<i;index++){
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新结点，并且新结点需要指向原来i位置的结点和i-1位置的结点
        Node newNode = new Node(t,pre,curr);
        //原来i位置前的节点指向新节点
        pre.next = newNode;
        //让i位置的后的一个结点指向新结点
        curr.pre = newNode;
        //元素的个数+1
        N++;
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

    //删除指定位置i处的元素，并返回被删除的元素
    public T remove(int i){
        //找到i位置前的结点
        Node pre = head;
        for(int index = 0;index<i;index++){
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //找到i位置的下一个节点
        Node nextNode = curr.next;
        //原来i位置前的节点指向i位置后的结点
        pre.next = nextNode;
        nextNode.pre = pre;
        //元素个数-1
        N--;
        //返回i位置处的值
        return curr.item;
    }


    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{
        private Node n;
        public TIterator(){
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
