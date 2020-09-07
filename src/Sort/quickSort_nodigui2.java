package Sort;

import java.util.Arrays;
import java.util.Random;


public class quickSort_nodigui2 {
    public static void main(String[] args) {
        int[] nums = {1,5,6,9,4,5,3,5,4};
        noQuickSort(nums,0,8);
        System.out.println(Arrays.toString(nums));
    }

    public static Random random = new Random(1000);

    public static void exchange(int[] array, int i, int j) {

        int temp = array[i];

        array[i] = array[j];

        array[j] = temp;

    }


    public static int getPivot(int[] array, int from, int to) {

        int target = array[to];

        int i = from - 1;

        for (int j = from; j < to; j++) {

            if (array[j] <= target) {

                i++;

                exchange(array, i, j);

            }

        }

        exchange(array, i + 1, to);

        return i + 1;

    }



    public static void insertSort(int[] L, int low, int high) {

        int i, j, temp;

        for (i = low + 1; i <= high; i++) {

            if (L[i] < L[i - 1]) {

                temp = L[i];

                for (j = i - 1; L[j] > temp && j >= low; j--) {

                    L[j + 1] = L[j];

                }

                L[j + 1] = temp;

            }

        }

    }



    public static void noQuickSort(int[] array, int from, int to) {

        int stack[] = new int[10000];

        int top = 0;

        int pivot = getPivot(array, from, to);

        int temp = pivot + 1;

        for (int i = pivot + 1; i < to + 1; i++) {

            if (array[i] > array[temp]) {

                temp = i;

            }

        }

        stack[top++] = to;

        stack[top++] = pivot;

        exchange(array, temp, to);

        for (;;) {

            if ((pivot - from) > 20) {

                pivot = getPivot(array, from, pivot - 1);

                stack[top++] = pivot;

            } else {

                insertSort(array, from, pivot - 1);

                from = pivot + 1;

                if (top == 1) {

                    break;

                }

                pivot = stack[top - 2];

                top--;

            }

        }

    }



    public static void quickSort(int[] array, int from, int to) {

        if (from < to) {

            int temp = from + (int) (Math.random() * (to - from));

            exchange(array, temp, to);

            int pivot = getPivot(array, from, to);

            quickSort(array, from, pivot - 1);

            quickSort(array, pivot + 1, to);

        }

    }

}