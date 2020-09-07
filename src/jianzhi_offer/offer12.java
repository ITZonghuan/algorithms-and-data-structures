package jianzhi_offer;

public class offer12 {
    public boolean exist(char[][] board,String word){
        char[] ch = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(dfs(board,ch,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,char[] ch,int i,int j,int k){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != ch[k]){
            return false;
        }
        if(k == ch.length-1) return true;
        Character temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board,ch,i+1,j,k+1) || dfs(board,ch,i-1,j,k+1) ||
                dfs(board,ch,i,j+1,k+1) || dfs(board,ch,i,j-1,k+1);
        board[i][j] = temp;
        return res;
    }
}
