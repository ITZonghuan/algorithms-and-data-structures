package algorithm.sortways.sort;

public class Insertion {
    public static void sort(Comparable [] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(greater(a[j-1],a[j])){
                    exc(a,j-1,j);
                }else {
                    break;
                }
            }
        }
    }
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    public static void exc(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
