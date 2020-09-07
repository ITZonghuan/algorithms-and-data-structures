package algorithm.weight_Graph;

import algorithm.table.linear.Queue;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    //加权无向图的邻接表,特殊注意，队列中储存的是Edge对象
    private Queue<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<DirectedEdge>();
        }
    }

    //获取图中顶点数量
    public int getV(){
        return V;
    }

    //获取图中边的数量
    public int getE(){
        return E;
    }

    //向加权有向图中添加一条边e
    public void addEdge(DirectedEdge e){
        //需要让e只出现在起点的邻接表中
        int v = e.from();
        adj[v].enqueue(e);
        E++;
    }

    //获取由顶点v指出的所有边
    public Queue<DirectedEdge> adj(int v){
        return adj[v];
    }

    //获取加权有向图的所有边
    public Queue<DirectedEdge> edges(){
        Queue<DirectedEdge> alledges = new Queue<>();
        for (int i = 0; i < adj.length; i++) {
            for (DirectedEdge edge : adj[i]) {
                alledges.enqueue(edge);
            }
        }
        return alledges;
    }
}
