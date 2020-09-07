package algorithm.sortways.test;

import algorithm.sortways.sort.Shell;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args) {
        Integer [] arr = {2,5,9,6,4,5,8,7,1,0,3};
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
