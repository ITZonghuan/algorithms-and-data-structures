package search.DFS;

public class leet547好友关系的连通分量数目 {
    public int findCircleNum(int[][] M){
        if(M == null || M.length == 0) return 0;
        int n = M.length;
        boolean[] hasVisited = new boolean[n];
        int num = 0;
        for(int i = 0;i<n;i++){
            if(!hasVisited[i]){
                dfs(M,i,hasVisited);
                num++;
            }
        }
        return num;
    }
    private void dfs(int[][] M,int i,boolean[] hasVisited){
        hasVisited[i] =true;
        for(int j=0;j<M.length;j++){
            if(M[i][j] == 1 && !hasVisited[j]){
                dfs(M,j,hasVisited);
            }
        }
    }
}
