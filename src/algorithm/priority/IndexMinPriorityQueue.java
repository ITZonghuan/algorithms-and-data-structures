package algorithm.priority;

//索引最小优先队列
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    //存放节点编号，即item的索引
    private int[] pq;
    private int[] qp;
    private int N;

    public T get(int i){
        return items[i];
    }

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity+1];
        this.qp = new int[capacity+1];
        this.N = 0;

        //默认情况下，队列中没有储存任何数据，让qp中的元素都为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    public boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }

    //交换堆中i索引和j索引处的值
    public void exc(int i,int j){

        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    //删除队列中最小的元素，并返回这个元素，返回的是节点编号而非节点的值
    public int delMin(){
        //pq存的是节点编号
        int min = pq[1];
        exc(1,N);
        qp[pq[N]] = -1;
        items[pq[N]] = null;
        pq[N] = -1;
        N--;
        sink(1);
        return min;
    }

    //往队列中插入一个元素，并关联索引i
    public void insert(int i,T t){
        while(contains(i)){
            return;
        }
        items[i] = t;
        N++;
        pq[N] = i;
        qp[i] = N;
        //调用上浮算法
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while(k>1){
            if(less(k,k/2)){
                exc(k,k/2);
            }
            k = k/2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //判断是否至少有左结点
        while(2*k <= N){
            int min;
            //判断是否有右结点
            if(2*k +1 <=N){
                if(less(2*k+1,2*k)){
                    min= 2*k + 1;
                }else{
                    min = 2*k;
                }
            }else{
                min = 2*k;
            }
            if(less(k,min)){
                break;
            }
            exc(min,k);
            k=min;
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

    //判断k对应的元素是否存在
    public boolean contains(int k){
        return qp[k]!=-1;
    }

    //把与索引i关联的元素修改为t
    public void changeItem(int i,T t){
        items[i] = t;
        int k = qp[i];
        sink(k);
        swim(k);
    }

    //最小元素关联的索引
    public int minIndex(){
        return pq[1];
    }

    //删除索引i关联的元素,并返回删除的元素
    public T delete(int i){
        T val = items[i];
        int k = qp[i];
        exc(k,N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[i] = null;
        N--;
        sink(k);
        swim(k);
        return val;
    }
}
