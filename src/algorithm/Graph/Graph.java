package algorithm.Graph;


import algorithm.table.linear.Queue;

//无向图
public class Graph {
    private final int V;
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    //创建一个包含V个顶点，但不包含边的图
    public Graph(int V){
        //初始化顶点数量
        this.V = V;
        //初始化边的数量
        this.E = 0;
        //初始化领接表
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    //获取图中顶点数量
    public int getV(){
        return V;
    };

    //获取图中边的数量
    public int getE(){
        return E;
    }

    //向图中添加一条边v-w
    public void addEdge(int v,int w){
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    //获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

}
