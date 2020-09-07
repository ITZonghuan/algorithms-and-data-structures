package algorithm.table.linear;

import java.util.Iterator;
import java.util.Objects;

public class SequenceList<T> implements Iterable<T>{
    //成员
    private T[] eles;
    private int N;

    //构造方法
    public SequenceList(int capacity){
        //初始化数组
        this.eles = (T[])new Object[capacity];
        //初始化长度
        this.N = 0;
    }

    //将一个线性表设置为空表
    public void clear(){
        this.N = 0;
    }

    //判断当前线性表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //获取线性表的长度
    public int length(){
        return N;
    }

    //获取指定位置的元素
    public T get(int i){
        return eles[i];
    }

    //向线性表中插入元素
    public void insert(T t){
        if(N == eles.length){
            resize(2*eles.length);
        }
        eles[N++] = t;
    }

    //在i索引处插入元素t
    public void insert(int i,T t){
        if(N == eles.length){
            resize(2*eles.length);
        }
        N++;
        for(int index = N; index > i; index--){
            eles[index] = eles[index-1];
        }
        eles[i] = t;
    }

    //删除指定i索引处的元素，并返回该元素
    public T remove(int i){
        T current = eles[i];
        for(int index = i;index<N-1;index++){
            eles[index] = eles[index+1];
        }
        //元素个数减1
        N--;

        if(N < eles.length/4){
            resize(eles.length/2);
        }

        return current;
    }

    //查找t元素第一次出现的位置
    public int indexOf(T t){
        for(int i = 0;i<N;i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    //数组扩容，新数组大小为newSize
    public void resize(int newSize){
        //定义一个临时数组，指向原数组
        T[] temp = eles;
        //创建新数组
        eles = (T[])new Object[newSize];
        //把原数组的数据拷贝到新数组即可
        for(int i = 0;i<N;i++){
            eles[i] = temp[i];
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private int cusor;
        public SIterator(){
            this.cusor = 0;
        }
        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}
