package Leetcode._0626;

/**
 * 最小的k个数
 * 快排模板，暂时未搞懂
 * 找数组第一个数作为分界值，然后分别
 */
public class jianzhi40 {
    public int[] getLeastNumbers(int[] arr,int k){
        if(k==0 || arr.length == 0) return new int[0];
        return quickSearch(arr,0,arr.length-1,k-1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k){
        return null;
    }

    //快排切分，返回下标，使得比nums[j]小的数都在j的左边，大的数都在右边
    private int partition(int[] nums,int lo,int hi){
        int v = nums[lo];
        int i = lo, j = hi+1;
        while (true){
            while(++i <= hi && nums[i] <v);
        }
    }

}
