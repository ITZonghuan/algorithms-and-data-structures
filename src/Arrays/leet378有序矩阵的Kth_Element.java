package Arrays;

/**
 * 二分法查找
 */
public class leet378有序矩阵的Kth_Element {
    public int kthSmallest(int[][] matrix,int k){
        int m = matrix.length-1,n=matrix[0].length-1;
        int low = matrix[0][0],high = matrix[m][n];
        while(low<=high){
            int cnt = 0;
            int mid = low + (high - low)/2;
            for(int i=0;i<=m;i++){
                for(int j=0;j<=n && matrix[i][j]<=mid;j++){
                    cnt++;
                }
            }
            if(cnt < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}
