package algorithm.table.linear;

import java.util.Iterator;

//队列（FIFO）、头结点、尾结点、插入和取出元素
public class Queue<T> implements Iterable<T>{
    private Node head;
    private Node last;
    int N;


    private class Node<T>{
        T item;
        Node next;
        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    //构造函数
    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //返回队列中元素的个数
    public int size(){
        return N;
    }
    //往队列中插入元素
    public void enqueue(T t){
        //如果尾结点为空
        if(last == null){
            last = new Node(t,null);
            head.next = last;
        }else{
            //如果尾结点不为空
            Node oldlast = last;
            last = new Node(t,null);
            oldlast.next = last;
        }
        //元素个数+1
        N++;
    }

    //从队列中拿出元素t
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        Node<T> oldfirst = head.next;
        head.next = oldfirst.next;
        N--;
        if(isEmpty()){
            last = null;
        }
        return oldfirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator{
        private Node n;
        public QIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
