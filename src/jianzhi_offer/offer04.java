package jianzhi_offer;

/**
 * 从左到右递增，从上到下递增
 */
public class offer04 {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(findNumberIn2DArray(20,matrix));
    }
    public static boolean findNumberIn2DArray(int target,int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int r = 0,c = matrix[0].length-1;
        while (r<matrix.length && c>=0){
            if(target < matrix[r][c]){
                c--;
            }else if(target > matrix[r][c]){
                r++;
            }else {
                return true;
            }
        }
        return false;
    }
}
