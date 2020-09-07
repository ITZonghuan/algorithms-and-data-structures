package Leetcode.first_day;

/**
 * 中等难度
 * 矩阵中是否包含某字符串所有字符的路径
 */

public class jianzhi12 {
    public boolean exist(char[][] board,String word){
        char[] words = word.toCharArray();
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    //深搜函数的传入参数有五个，矩阵，目标单词数组，当前矩阵的索引i,j,以及当前单词的索引k
    public boolean dfs(char[][]board,char[] word,int i,int j,int k){
        if(i>=board.length || i<0 || j>= board.length || j<0 || board[i][j] != word[k]){
            return false;
        }
        if(k == word.length-1){
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board,word,i+1,j,k+1) || dfs(board,word,i-1,j,k+1)
                || dfs(board,word,i,j+1,k+1) || dfs(board,word,i,j-1,k+1);
        board[i][j] = tmp;
        return res;
    }
}
