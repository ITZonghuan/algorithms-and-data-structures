package algorithm.sortways.sort;

public class Merge {
    //归并排序所需要的辅助数组
    private static Comparable [] assist;

    //判断大小
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    //交换位置
    private static void exh(Comparable [] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //排序
    public static void sort(Comparable [] a){
        //1、初始化辅助数组assist
        assist = new Comparable[a.length];
        //2、定义一个lo变量和hi变量，分别记录数组中最小的索引和最大的索引
        int lo = 0;
        int hi = a.length - 1;
        //3、调用sort重载方法完成数组a中，从索引lo到索引hi的元素排序
        sort(a,lo,hi);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        //做安全性检验
        if(hi<=lo){
            return;
        }
        //对lo到hi之间的数组分为两个组
        int mid = lo + (hi - lo)/2;
        //对每个组的数据进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);

        //排序后的数组进行归并
        merge(a,lo,mid,hi);
    }

    private static void merge(Comparable [] a,int lo,int mid,int hi){
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;
        //遍历，移动p1指针和p2指针，比较对应索引处的值，找出小的那个，放在辅助数组的对应索引处
        while(p1<=mid && p2<=hi){
            if(greater(a[p1],a[p2])){
                assist[i++] = a[p2++];
            }else{
                assist[i++] = a[p1++];
            }
        }
        //遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应元素放在辅助数组的对应索引处
        while(p1 <= mid){
            assist[i++] = a[p1++];
        }
        //遍历，如果p2的指针没有走完，那么顺序移动p2指针，把对应元素放在辅助数组的对应索引处
        while(p2 <= hi){
            assist[i++] = a[p2++];
        }
        //把辅助数组中的元素拷贝到原数组中
        for(int index = lo;index<=hi;index++){
            a[index] = assist[index];
        }
    }
}
