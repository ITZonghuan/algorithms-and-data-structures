package Arrays;

public class leet566改变矩阵的维度 {
    public int[][] matrixReshape(int[][] nums,int r,int c){
        int m = nums.length,n = nums[0].length;
        if(m*n != r*c) return nums;
        int index = 0;
        int[][] reshape = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j =0;j<c;j++){
                //   index/n表示第几行，index%n表示该行的第几个
                reshape[i][j] = nums[index/n][index%n];
                index++;
            }
        }
        return reshape;
    }
}
