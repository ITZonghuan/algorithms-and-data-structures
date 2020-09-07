package algorithm.sortways.test;

import algorithm.sortways.sort.Selection;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args){
        Integer [] arr = {3,6,9,8,4,2,7,1,5,0};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
