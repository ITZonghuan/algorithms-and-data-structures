package algorithm.sortways.sort;

public class Shell {
    public static void sort(Comparable [] a){
        //1、确定步长h
        int h = 1;
        while(h < a.length/2){
            h = 2 * h + 1;
        }
        //希尔排序
        while(h >= 1){
            //排序
            //2.1 找到待插入数据
            for(int i = h;i<a.length;i++){
                //2.2 找到待插入的位置
                for(int j = i; j >= h; j-=h){
                    if(greater(a[j-h],a[j])){
                        exch(a,j-h,j);
                    }else{
                        break;
                    }
                }
            }
            //排序完之后减小h的值
            h = h/2;
        }
    }

    /*
    元素比较大小
     */
    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


