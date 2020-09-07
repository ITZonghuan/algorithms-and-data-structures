package Leetcode.first_day;

/**
 * n*m的递增二维数组，判断是否存在某个数
 */
public class jianzhi04 {
    public boolean findNumberIn2DArray(int[][] matrix,int target){
        int i = matrix.length - 1,j = 0;
        while (i>=0 && j < matrix[0].length){
            if(matrix[i][j]>target){
                i--;
            }else if(matrix[i][j]<target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
