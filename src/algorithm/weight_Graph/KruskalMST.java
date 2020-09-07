package algorithm.weight_Graph;

import algorithm.priority.MinPriorityQueue;
import algorithm.table.linear.Queue;
import algorithm.tree.UF_Tree_Weighted;

public class KruskalMST {
    //保存最小生成树的所有边
    private Queue<Edge> mst;
    //索引代表顶点，使用uf.connect(v,w)可以判断顶点v和顶点w是否在同一颗树中，使用uf.union(v,w)可以合并顶点v和w所在的树
    private UF_Tree_Weighted uf;
    //储存图中所有的边，使用最小优先队列，对边按照权重进行排序
    private MinPriorityQueue<Edge> pq;

    public KruskalMST(EdgeWeightedGraph G){
        this.mst = new Queue<Edge>();

        this.uf = new UF_Tree_Weighted(G.getV());
        //因为最小优先队列存放的是边，舍弃了0索引处的值，从1开始
        this.pq = new MinPriorityQueue<>(G.getE() + 1);

        //把图中所有的边储存到pq中
        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }

        //遍历pq队列，拿到最小的权重边，进行处理
        while(!pq.isEmpty()){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            //判断这两个顶点是否已经在同一颗树中
            if(uf.connected(v,w)){
                continue;
            }
            uf.union(v,w);
            //让边e进入到mst队列中
            mst.enqueue(e);
        }
    }

    //获取最小生成树的所有边
    public Queue<Edge> mst(){
        return mst;
    }

}
