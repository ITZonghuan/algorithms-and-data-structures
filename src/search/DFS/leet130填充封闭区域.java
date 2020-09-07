package search.DFS;

/**
 * 先管边界连通的换成"T",再处理中间的
 */
public class leet130填充封闭区域 {
    private int m = 0;
    private int n = 0;
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board){
        if(board == null || board.length ==0){
            return;
        }
        m = board.length;
        n = board[0].length;
        for(int i=0;i<n;i++){
            dfs(board,0,i);
            dfs(board,m-1,i);
        }
        for(int j=0;j<m;j++){
            dfs(board,j,0);
            dfs(board,j,n-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board,int r,int c){
        if(r<0 || r>=m || c<0 || c>=n || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        for(int[] n:direction){
            dfs(board,r+n[0],c+n[1]);
        }
    }
}
