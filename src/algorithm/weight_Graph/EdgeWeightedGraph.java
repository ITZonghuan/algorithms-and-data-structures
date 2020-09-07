package algorithm.weight_Graph;

import algorithm.table.linear.Queue;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    //加权无向图的邻接表,特殊注意，队列中储存的是Edge对象
    private Queue<Edge>[] adj;

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<>();
        }
        /*
        for (Queue<Edge> edges : adj) {
            edges = new Queue<>();
        }
         */
    }

    //获取图中顶点数量
    public int getV(){
        return V;
    }

    //获取图中边的数量
    public int getE(){
        return E;
    }

    //向加权无向图中添加一条边e
    public void addEdge(Edge e){
        //需要让e同时出现在这条边的两个顶点的邻接表中
        int v = e.either();
        int w = e.other(v);
        adj[v].enqueue(e);
        adj[w].enqueue(e);
        E++;
    }

    //获取和顶点v关联的所有边
    public Queue<Edge> adj(int v){
        return adj[v];
    }

    //获取加权无向图的所有边
    public Queue<Edge> edges(){
        Queue<Edge> alledges = new Queue<>();
        for (int i = 0; i < adj.length; i++) {
            for (Edge edge : adj[i]) {
                if(i<edge.other(i)){
                    alledges.enqueue(edge);
                }
            }
        }
        return alledges;
    }
}
