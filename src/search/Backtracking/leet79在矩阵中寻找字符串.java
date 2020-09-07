package search.Backtracking;

public class leet79在矩阵中寻找字符串 {
    private int[][] direction ={{1,0},{-1,0},{0,1},{0,-1}};
    private int m; //行
    private int n; //列

    public boolean exist(char[][] board,String word){
        if(word == null || word.length() == 0){
            return true;
        }
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for(int r = 0;r<m;r++){
            for(int c = 0;c<n;c++){
                if(backtracking(0,r,c,hasVisited,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtracking(int curlen,int r,int c,boolean[][] visited,char[][] board,String word){
        //1、判断结束条件
        if(curlen == word.length()){
            return true;
        }
        //2、判断边界条件
        if(r<0 || r>=m || c<0 || c>=n
                || board[r][c] !=word.charAt(curlen)
        || visited[r][c]){
            return false;
        }
        //3、标记访问
        visited[r][c] = true;
        //4、循环
        for(int[] d:direction){
            if(backtracking(curlen + 1,r+d[0],c+d[1],visited,board,word)){
                return true;
            }
        }
        //5、复原+返回
        visited[r][c] = false; //复原
        return false;
    }
}
