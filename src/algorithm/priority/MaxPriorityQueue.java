package algorithm.priority;

public class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;
    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    public boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换堆中i索引和j索引处的值
    public void exc(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //删除队列中最大的元素，并返回这个元素
    public T delMax(){
        T max = items[1];
        exc(1,N);
        N--;
        sink(1);
        return max;
    }

    //往队列中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while(k>1){
            if(less(k/2,k)){
                exc(k,k/2);
            }
            k = k/2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //判断是否至少有左结点
        while(2*k <= N){
            int max;
            //判断是否有右结点
            if(2*k +1 <=N){
                if(items[2*k].compareTo(items[2*k+1])>0){
                    max = 2*k;
                }else{
                    max = 2*k + 1;
                }
            }else{
                max = 2*k;
            }
            if(less(max,k)){
                break;
            }
            exc(max,k);
            k=max;
        }
    }

    //获取队列中元素的个数
    public int size(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }
}
