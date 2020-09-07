package Double_pointer;

import java.util.Arrays;
import java.util.Comparator;

public class Arrays实现多维数组排序 {
    public static void main(String[] args) {
        int[][] arr = {{1,4,5},{2,5,3},{1,2,3},{5,4,3},{1,4,3}};
        //int[][] arr = {{1,4},{2,5},{1,2},{5,4},{1,4}};
        //Arrays实现多维数组排序
        //System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            //从小到大排序、或者从大到小
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o2[0] - o1[0];
                }else if(o1[1] != o2[1]){
                    return o2[1] - o1[1];
                }else{
                    return o2[2] - o1[2];
                }
            }
        });
        //System.out.print(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
