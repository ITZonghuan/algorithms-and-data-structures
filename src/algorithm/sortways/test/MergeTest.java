package algorithm.sortways.test;

import algorithm.sortways.sort.Merge;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer [] arr = {2,5,6,2,4,8,4,3,2,6,5,4,2,8,9,3,0,1,4,7,0,5,6,0,4,8,2,0};
        Merge.sort(arr);
        System.out.print(Arrays.toString(arr));
    }
}
