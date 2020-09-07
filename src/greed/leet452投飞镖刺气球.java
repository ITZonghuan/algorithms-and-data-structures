package greed;

import java.util.Arrays;
import java.util.Comparator;

public class leet452投飞镖刺气球 {
    public int findMinArrowShots(int[][] points){
        if(points.length == 0) return 0;
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] c1,int[] c2){
                return c1[1] - c2[1];
            }
        });
        int cont = 1;
        int end = points[0][1];
        for(int i =1;i<points.length;i++){
            if(points[i][0] <= end){
                continue;
            }
            cont++;
            end = points[i][1];
        }
        return cont;
    }
}
