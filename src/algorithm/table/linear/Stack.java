package algorithm.table.linear;

import java.util.Iterator;

//栈数据结构(FILO)、弹栈、出栈
public class Stack<T> implements Iterable<T>{
    private Node head;
    private int N;

    //结点类
    private class Node{
        private T item;
        private Node next;
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    //无参构造函数
    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    //返回栈的大小
    public int size(){
        return N;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //压栈
    public void press(T t){
        //找到首结点的下一个结点
        Node oldfirst = head.next;
        //创建新结点
        Node newNode = new Node(t, null);
        //首结点指向新的结点
        head.next = newNode;
        //新结点指向首结点的下一个结点
        newNode.next = oldfirst;
        //元素个数＋1
        N++;
    }

    //弹栈
    public T pop(){
        //找到首结点的下一个结点
        Node oldfirst = head.next;
        //安全性检验
        if(isEmpty()){
            return null;
        }
        //首结点指向首结点下一个结点的下一个结点
        head.next = oldfirst.next;
        //元素个数减1
        N--;
        //返回首结点的下一个结点
        return oldfirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private Node n;
        public SIterator(){
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
