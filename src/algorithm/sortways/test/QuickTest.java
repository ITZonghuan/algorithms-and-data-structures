package algorithm.sortways.test;

import algorithm.sortways.sort.Quick;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] a = {3,5,9,6,0,1,2,4,2,7,6,5,0,1,2,5,3,5,9};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
