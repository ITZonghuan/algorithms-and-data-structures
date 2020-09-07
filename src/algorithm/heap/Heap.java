package algorithm.heap;


public class Heap<T extends Comparable<T>>{
    private T[] items;
    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换堆中索引i处的值和索引j处的值
    private void excl(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while(k>1){
            if(less(k/2,k)){
                excl(k/2,k);
            }
            k = k/2;
        }
    }

    //删除堆中最大的元素，并返回这个元素
    public T delMax(){
        T max = items[1];
        //交换根节点与最大索引处结点
        excl(1,N);
        items[N] = null;
        N--;
        //使用下沉算法
        sink(1);
        return max;
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //判断至少存在左节点
        while(2*k <= N){
            //记录较大结点所在的索引
            int max;
            //先判断是否有右结点
            if(2*k + 1<= N){
                if(less(2*k,2*k+1)){
                    max = 2*k+1;
                }else{
                    max = 2*k;
                }
            }else{
                max = 2*k;
            }
            //判断当前结点和较大结点的值
            if(less(k,max)){
                excl(k,max);
            }else{
                break;
            }
            k = max;
        }
    }
}
