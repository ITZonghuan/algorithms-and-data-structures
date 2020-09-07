package Arrays;

public class leet240有序矩阵查找 {
    public boolean searchMatrix(int[][] matrix,int target){
        if(matrix == null) return false;
        int m = matrix.length-1,n=0;
        while(m >=0 && n<matrix[0].length){
            if(matrix[m][n] > target){
                m--;
            }else if(matrix[m][n] < target){
                n++;
            }else{
                return true;
            }
        }
        return false;
    }
}
