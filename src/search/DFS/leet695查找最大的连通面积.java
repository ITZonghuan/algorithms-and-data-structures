package search.DFS;

/**
 * 一般用栈实现DFS
 * 常常用来求解可达性问题
 */
public class leet695查找最大的连通面积 {
    private int m = 0;
    private int n = 0;
    //定义四个方向
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid){
        if(grid == null) return 0;
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        //二维矩阵循环遍历
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxArea = Math.max(maxArea,dfs(grid,i,j));
            }
        }
        return maxArea;
    }
    //定义一个dfs函数，r,c为行/列的索引
    private int dfs(int[][] grid,int r,int c){
        if(r<0 || r>=m || c<0 || c>= n || grid[r][c] == 0){
            return 0;
        }
        //走过该片区域之后，将其设为0
        grid[r][c] = 0;
        int area = 1;
        for(int[] n:direction){
            //dfs核心，就是递归调用
            area += dfs(grid,r+n[0],c+n[1]);
        }
        return area;
    }
}
