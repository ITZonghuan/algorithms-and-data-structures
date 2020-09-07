package algorithm.Graph;

import algorithm.table.linear.Queue;

//有向图DiGraph
public class DiGraph {
    private final int V;
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public DiGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    public int getV(){
        return V;
    }

    public int getE(){
        return E;
    }

    //向有向图中添加一条边
    public void addEdge(int v,int w){
        //只需要让w出现在v的领接表中
        adj[v].enqueue(w);
        E++;
    }

    //获取由v指出的边所连接的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

    //该图的反向图
    private DiGraph reverse(){
        DiGraph d = new DiGraph(getV());
        for (int v = 0; v < V; v++) {
            for (Integer w : adj[v]) {
                d.addEdge(w,v);
            }
        }
        return d;
    }
}
