package algorithm.weight_Graph;

import algorithm.priority.IndexMinPriorityQueue;
import algorithm.table.linear.Queue;

public class PrimeMST {
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private Edge[] edgeTo;
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private double[] distTo;
    //索引代表顶点，如果当前顶点已经在树中，则值为true
    private boolean[] marked;
    //存放树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;

    //根据一副加权无向图，创建最小生成树计算对象
    public PrimeMST(EdgeWeightedGraph G){
        this.edgeTo = new Edge[G.getV()];
        this.distTo = new double[G.getV()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        this.marked = new boolean[G.getV()];
        this.pq = new IndexMinPriorityQueue<Double>(G.getV());

        //默认让顶点0进入到树中，但是树中只有一个顶点，因此，0顶点默认没有和其他顶点相连，所以让distTo对应位置处储存0.0
        distTo[0] = 0.0;
        pq.insert(0,0.0);

        //遍历索引优先队列，拿到最小横切边对应的顶点，把该顶点加入到最小生成树中
        while (!pq.isEmpty()){
            visit(G,pq.delMin());
        }
    }

    //将顶点v添加到最小生成树中，并且更新数据
    private void visit(EdgeWeightedGraph G,int v){
        //把顶点v添加到最小生成树中
        marked[v] = true;
        //更新数据
        for (Edge e : G.adj(v)) {
            //获取e边的另外一个顶点
            int w = e.other(v);
            //判断另外一个顶点是否已经在树中，如果不在树中，才更新数据
            if(marked[w]){
                continue;
            }

            //判断边e的权重是否小于从w顶点到树中已经存在的最小边的权重
            if(e.getWeight()<distTo[w]){
                edgeTo[w] = e;
                distTo[w] = e.getWeight();
                if(pq.contains(w)){
                    pq.changeItem(w,e.getWeight());
                }else{
                    pq.insert(w,e.getWeight());
                }
            }
        }
    }

    //获取最小生成树的所有边
    public Queue<Edge> edges(){
        Queue<Edge> alledges = new Queue<>();
        for (int i = 0; i < edgeTo.length; i++) {
            if(edgeTo[i]!=null){
                alledges.enqueue(edgeTo[i]);
            }
        }
        return alledges;
    }

}
