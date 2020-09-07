package algorithm.Graph;

import algorithm.table.linear.Queue;
import algorithm.table.linear.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private boolean hasCycle;
    //索引代表顶点，使用栈的思想，记录当前顶点有没有处于正在搜索的有向路径上
    private boolean[] onStack;

    public DirectedCycle(DiGraph G) {
        this.marked = new boolean[G.getV()];
        this.hasCycle = false;
        this.onStack = new boolean[G.getV()];
        for(int i = 0;i<G.getV();i++){
            if(!marked[i]){
                dfs(G,i);
            }
        }
    }

    //基于深度优先搜索，检测图G中是否有环
    private void dfs(DiGraph G,int s){
        marked[s] = true;
        //把当前顶点进栈
        onStack[s] = true;
        for (Integer i : G.adj(s)) {
            if(!marked[i]){
                dfs(G,i);
            }
            if(onStack[i]){
                hasCycle = true;
                return;
            }
        }

        //把当前顶点出栈
        onStack[s] = false;
    }

    //判断图中是否有环
    public boolean hasCycle(){
        return hasCycle;
    }
}
