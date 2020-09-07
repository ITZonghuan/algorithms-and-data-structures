package algorithm.sortways.test;

import algorithm.sortways.sort.Insertion;

import java.util.Arrays;

public class InsertionTest {
    public static void main(String[] args){
        Integer [] arr = {3,6,9,8,4,2,7,1,5,0};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
