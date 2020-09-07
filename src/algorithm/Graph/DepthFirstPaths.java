package algorithm.Graph;

import algorithm.table.linear.Stack;

public class DepthFirstPaths {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //起点
    private int s;

    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s) {
        this.marked = new boolean[G.getV()];
        this.s = s;
        this.edgeTo = new int[G.getV()];
        dfs(G,s);
    }

    //使用深度优先搜索，找出G图中v顶点的所有相邻顶点
    private void dfs(Graph G, int v){
        marked[v] = true;
        for (Integer integer : G.adj(v)) {
            if(!marked[integer]){
                edgeTo[integer] = v;
                dfs(G,integer);
            }
        }
    }

    //判断v顶点与s顶点是否存在路径
    public boolean hasPathTo(int v){
        return marked[v];
    }

    //找出从起点s到顶点v的路径(就是该路径经过的顶点)
    public Stack<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }

        Stack<Integer> path = new Stack<>();
        for(int i = v;i!=s;i=edgeTo[i]){
            path.press(i);
        }
        path.press(s);
        return path;
    }
}
