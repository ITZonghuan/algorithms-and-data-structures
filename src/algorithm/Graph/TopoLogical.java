package algorithm.Graph;

import algorithm.table.linear.Stack;

public class TopoLogical {
    //顶点的拓扑排序
    private Stack<Integer> order;
    public TopoLogical(DiGraph G){
        this.order = new Stack<Integer>();
        if(!isCycle(G)){
            DepthFirstOrder dfo = new DepthFirstOrder(G);
            Stack<Integer> re = dfo.reversePost();
            order = re;
        }
    }

    public boolean isCycle(DiGraph G){
        DirectedCycle dc = new DirectedCycle(G);
        return dc.hasCycle();
    }

    public Stack<Integer> order(){
        return order;
    }
}
