package greed;
/**
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，
 * 留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大
 */

import java.util.Arrays;
import java.util.Comparator;

public class leet435不重叠的区间个数 {
    public int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length == 0) return 0;
        //这里用到了Arrays对多维数组排序的方法
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                //按照区间尾部大小进行排序
                return o1[1] - o2[1];
            }
        });
        //cont记为不重叠区间的个数
        int cont = 1;
        //end设为第一个区间的尾部
        int end = intervals[0][1];
        //遍历每个区间
        for(int i = 1;i<intervals.length;i++){
            //如果当前区间的头部小于前一个区间的尾部，跳过本次循环
            if(intervals[i][0] < end){
                continue;
            }
            end = intervals[i][1];
            cont++;
        }
        return intervals.length - cont;
    }
}
