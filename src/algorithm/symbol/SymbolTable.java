package algorithm.symbol;

import java.util.Iterator;

public class SymbolTable<key,value> implements Iterable<value>{
    private Node head;
    private int N;


    //结点类
    private class Node{
        private key key;
        private value value;
        private Node next;
        public Node(key key,value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    //构造方法
    public SymbolTable(){
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    //成员方法
    public value get(key key){
        //根据键key，找对应的值
        Node n = head;
        while (n.next != null){
            n = n.next;
            if(n.key.equals(key)){
                return n.value;
            }
        }
        return  null;
    }

    //向符号表中插入一个键值对
    public void put(key key,value value){
        //1.符号表中已存在键为key的键值对，替换value即可
        Node n = head;
        while(n.next != null){
            n = n.next;
            if(n.key.equals(key)){
                n.value = value;
                return;
            }
        }
        //2.符号表中未存在键为key的键值对，创建新结点，保存新的键值对，插入到链表的头部
        Node newNode = new Node(key,value,null);
        Node oldfirst = head.next;
        newNode.next = oldfirst;
        head.next = newNode;

        //3.数量+1
        N++;
    }

    public void delete(key key){
        //删除键为key的键值对
        Node n = head;
        while(n.next != null){
            if(n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<value> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<value>{
        public Node n;
        public SIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public value next() {
            n = n.next;
            return n.value;
        }
    }
}
