package algorithm.sortways.sort;

public class Quick {
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable [] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }
    public static void sort(Comparable[] a,int lo,int hi){
        //安全性检验
        if(hi <= lo){
            return;
        }
        //分组（左子组和右子组）
        int part_val = partion(a,lo,hi);
        //左子组排序
        sort(a,lo,part_val-1);
        //右子组排序
        sort(a,part_val+1,hi);
    }
    public static int partion(Comparable[] a,int lo,int hi){
        //返回分界值调换位置后的索引
        //确定分界值
        Comparable key = a[lo];
        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left = lo;
        int right = hi +1;
        while(true){
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            while (greater(key,a[--right])){
                //设置一个终止条件
                if(right == lo){
                    break;
                }
            }
            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while(greater(a[++left],key)){
                //设置一个终止条件
                if(left == hi){
                    break;
                }
            }
            //判断left>=right，如果是，则证明元素扫描完毕，结束循环，如果不是，交换元素即可
            if(left >= right){
                break;
            }else{
                exch(a,left,right);
            }
        }
        //最后交换分界值和左、右指针同时指向的值
        exch(a,lo,right);
        return right;
    }
}
