package algorithm.weight_Graph;

import algorithm.priority.IndexMinPriorityQueue;
import algorithm.table.linear.Queue;

//最短路径树
public class DijkstraSP {
    //索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边
    private DirectedEdge[] edgeTo;
    //索引代表顶点，值表示从顶点s到当前顶点的最短路径的 总权重
    private double[] distTo;
    //查询从起点s到顶点v的最短路径中所有的边,储存起点到该点的总权重
    private IndexMinPriorityQueue<Double> pq;

    //根据一副加权有向图G和顶点s，创建一个计算顶点为s的最短路径树对象
    public DijkstraSP(EdgeWeightedDigraph G,int s){
        this.edgeTo = new DirectedEdge[G.getV()];
        this.distTo = new double[G.getV()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        this.pq = new IndexMinPriorityQueue<>(G.getV());

        //默认让顶点s进入到最短路径树中
        distTo[s] = 0.0;
        pq.insert(s,0.0);

        //遍历pq
        while (!pq.isEmpty()){
            relax(G,pq.delMin());
        }
    }

    //松弛图G中的顶点v
    private void relax(EdgeWeightedDigraph G,int v){
        for (DirectedEdge de : G.adj(v)) {
            //获取到该边的终点w
            int w = de.to();

            //通过松弛技术，判断从起点s到顶点w的最短路径是否需要先从顶点s到顶点v,再到顶点w
            if(distTo[v] + de.getWeight()<distTo[w]){
                distTo[w] = distTo[v] + de.getWeight();
                edgeTo[w] = de;

                //判断pq中是否已经存在顶点w
                if(pq.contains(w)){
                    pq.changeItem(w,distTo[w]);
                }else{
                    pq.insert(w,distTo[w]);
                }
            }
        }
    }

    //获取从顶点s到顶点v的最短路径的总权重
    public double distTo(int v){
        return distTo[v];
    }

    //判断从顶点s到顶点v是否可达
    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    //查询从起点s到顶点v的最短路径的所有的边
    public Queue<DirectedEdge> pathTo(int v){
        //判断从顶点s到v是否可达
        if(!hasPathTo(v)){
            return null;
        }
        Queue<DirectedEdge> e = new Queue<>();
        while(true){
            if(edgeTo[v]==null){
                break;
            }
            e.enqueue(edgeTo[v]);
            v = edgeTo[v].from();
        }
        return e;
    }

}
