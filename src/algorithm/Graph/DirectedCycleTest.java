package algorithm.Graph;

public class DirectedCycleTest {
    public static void main(String[] args) {
        DiGraph dg = new DiGraph(13);
        dg.addEdge(0,6);
        dg.addEdge(0,2);
        dg.addEdge(0,1);
        dg.addEdge(5,0);
        dg.addEdge(6,4);
        dg.addEdge(4,5);
        dg.addEdge(4,3);
        dg.addEdge(7,8);
        dg.addEdge(9,10);
        dg.addEdge(9,12);
        dg.addEdge(9,11);
        dg.addEdge(12,11);

        DirectedCycle dig = new DirectedCycle(dg);
        System.out.println("当前图中是否有环：" + dig.hasCycle());
    }
}
