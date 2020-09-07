package search.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet417能达到的太平洋和大西洋区域 {
    private int m;
    private int n;
    private int[][] matrix;
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix){
        //列表中的列表可以用一个 new ArrayList<>()解决~
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(i,0,canReachP);
            dfs(i,n-1,canReachA);
        }
        for(int j=0;j<n;j++){
            dfs(0,j,canReachP);
            dfs(m-1,j,canReachA);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(canReachA[i][j] && canReachP[i][j]){
                    //Arrays.asList() 可以转换为列表
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int r, int c,boolean[][] canReach){
        if(canReach[r][c]){
            return;
        }
        canReach[r][c] = true;
        for(int[] d:direction){
            int nextR = r + d[0];
            int nextC = c + d[1];
            if(nextR < 0 || nextR>=m || nextC<0 || nextC>=n || matrix[r][c] > matrix[nextR][nextC]){
                continue;
            }
            dfs(nextR,nextC,canReach);
        }
    }
}
