package algorithm.heap;

import java.util.Arrays;

public class HeapSortTest {
    public static void main(String[] args) {
        String [] source = {"A","C","D","B","F","E","H","X","Y","Z","M","L","Q","P","O","N"};
        HeapSort.sort(source);
        System.out.println(Arrays.toString(source));
    }
}
