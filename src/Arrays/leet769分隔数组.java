package Arrays;

public class leet769分隔数组 {
    public int maxChunksToSorted(int[] arr){
        int rightValue = arr[0];
        int cnt = 0;
        for(int i =0;i<arr.length;i++){
            rightValue = Math.max(rightValue,arr[i]);
            if(rightValue == i) cnt++;
        }
        return cnt;
    }
}
