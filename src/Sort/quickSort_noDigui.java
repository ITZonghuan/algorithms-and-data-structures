package Sort;

import java.util.Arrays;
import java.util.Stack;

public class quickSort_noDigui{
    public static void main(String[] args) {
        int[] nums = {1,6,9,5,7,8,1,5,2,3};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void quickSort(int[] a) {
        if (a == null)
            return;
        qSort2(a, 0, a.length - 1);
    }
    public static void qSort2(int[] a, int low, int high) {
        int pivot;
        if (low >= high)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(low);
        stack.push(high);
        while (!stack.empty()) {
            // 先弹出high,再弹出low
            high = stack.pop();
            low = stack.pop();
            pivot = partition(a, low, high);
            // 先压low,再压high
            if (low < pivot - 1) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }

    /**
     * 对数组a中下标从low到high的元素，选取基准元素pivotKey，
     * 根据与基准比较的大小，将各个元素排到基准元素的两端。
     * 返回值为最后基准元素的位置
     */
    public static int partition(int[] a, int low, int high) {

        // 三数取中,将中间元素放在第一个位置
        if (a[low] > a[high])
            swap(a, low, high);
        if (a[(low + high) / 2] > a[high])
            swap(a, (low + high) / 2, high);
        if (a[low] < a[(low + high) / 2])
            swap(a, (low + high) / 2, low);

        int pivotKey = a[low]; // 用第一个元素作为基准元素
        while (low < high) { // 两侧交替向中间扫描
            while (low < high && a[high] >= pivotKey)
                high--;
            a[low] = a[high];
            // swap(a, low, high); //比基准小的元素放到低端
            while (low < high && a[low] <= pivotKey)
                low++;
            a[high] = a[low];
            // swap(a, low, high); //比基准大的元素放到高端
        }
        a[low] = pivotKey; // 在中间位置放回基准值
        return low; // 返回基准元素所在位置
    }
    public static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}