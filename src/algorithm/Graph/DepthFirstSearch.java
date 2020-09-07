package algorithm.Graph;

public class DepthFirstSearch {
    //索引代表顶点，值代表是否已经被搜索过
    private boolean marked[];
    //记录有多少个顶点与s相通
    private int count;
    public DepthFirstSearch(Graph G, int s){
        this.marked = new boolean[G.getV()];
        this.count = 0;
        dfs(G,s);
    }

    //使用深度优先搜索找到G图中与v相通的所有顶点
    private void dfs(Graph G,int v){
        //将顶点v变为已搜索
        marked[v] = true;
        count++;
        for (Integer w : G.adj(v)) {
            if(!marked(w)){
                dfs(G,w);
            }
        }
    }

    //判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }

    //获取与s顶点连接的所有顶点个数
    public int count(){
        return count;
    }

}
