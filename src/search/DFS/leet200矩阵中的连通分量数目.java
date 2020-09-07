package search.DFS;

public class leet200矩阵中的连通分量数目 {
    private int m = 0;
    private int n = 0;
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid){
        if(grid == null || grid.length ==0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int num = 0;
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    num++;
                }
            }
        }
        return num;
    }
    private void dfs(char[][] grid,int i,int j){
        if(grid == null || i<0 || i>=m || j<0 || j>=n || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for(int[] n:direction){
            dfs(grid,i+n[0],j+n[1]);
        }
    }
}
