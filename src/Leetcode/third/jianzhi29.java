package Leetcode.third;

/**
 * 顺时针打印矩阵
 */
public class jianzhi29 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ints = spiralOrder(arr);
        for (int anInt : ints) {
            System.out.print(anInt + "、");
        }
    }
    public static int[] spiralOrder(int[][] matrix){
        if(matrix.length == 0) return new int[0];
        int l = 0;
        int r = matrix[0].length-1;
        int t = 0;
        int b = matrix.length - 1;
        int x = 0;
        int[] res = new int[(r+1)*(b+1)];
        while(true){
            for(int i=l;i<=r;i++){
                res[x++] = matrix[t][i];
            }
            if(++t>b) break;
            for(int i = t;i<=b;i++){
                res[x++] = matrix[i][r];
            }
            if(l>--r) break;
            for(int i = r;i>=l;i--){
                res[x++] = matrix[b][i];
            }
            if(--b<t) break;
            for(int i = b;i>=t;i--){
                res[x++] = matrix[i][l];
            }
            if(++l>r) break;
        }
        return res;
    }
}
