package greed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class leet406身高重组队列 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);
        for(int[] i:people){
            for (int j:i){
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }
    public static int[][] reconstructQueue(int[][] people){
        if(people == null) return new int[0][0];
        //Arrays.sort(people,(a,b) ->(a[0] == b[0]?(a[1] - b[1]):(b[0] - a[0])));
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    //身高相同，身高名次升序排列
                    return o1[1] - o2[1];
                }else{
                    //身高不同，身高降序排列
                    return o2[0] - o1[0];
                }
            }
        });
        List<int[]> list = new LinkedList<>();
        for(int[] i:people){
            //list.add(int index,int a) 索引index处插入a
            list.add(i[1],i);
        }
        //使用了list.toArray(int[b.length][] a)方法
        return list.toArray(new int[people.length][]);
    }
}
