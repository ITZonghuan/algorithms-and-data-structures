package algorithm.Graph;

import algorithm.Graph.Graph;

public class DepthFirstSearchTest {
    public static void main(String[] args) {
        //准备图对象
        Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(3,5);
        G.addEdge(3,4);
        G.addEdge(5,4);
        G.addEdge(6,4);
        G.addEdge(7,8);
        G.addEdge(9,10);
        G.addEdge(9,11);
        G.addEdge(9,12);
        G.addEdge(11,12);

        //准备深度优先搜索对象
        DepthFirstSearch dfs = new DepthFirstSearch(G, 0);


        //测试与起点相通的顶点数量
        int count = dfs.count();
        System.out.println("与起点相通的顶点数量是：" + count);
        //判断某个顶点是否与起点相通
        System.out.println("12是否与起点相通：" + dfs.marked(12));
        System.out.println("10是否与起点相通：" + dfs.marked(10));
        System.out.println("6是否与起点相通：" + dfs.marked(6));
    }
}
