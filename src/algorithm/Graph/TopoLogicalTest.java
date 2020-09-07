package algorithm.Graph;

public class TopoLogicalTest {
    public static void main(String[] args) {
        DiGraph dg = new DiGraph(13);
        dg.addEdge(0,6);
        dg.addEdge(0,2);
        dg.addEdge(0,1);
        //将此处修改为无环
        //dg.addEdge(5,0);
        dg.addEdge(6,4);
        dg.addEdge(4,5);
        dg.addEdge(4,3);
        dg.addEdge(7,8);
        dg.addEdge(9,10);
        dg.addEdge(9,12);
        dg.addEdge(9,11);
        dg.addEdge(12,11);

        TopoLogical tg = new TopoLogical(dg);
        StringBuilder sb = new StringBuilder();
        if(tg.isCycle(dg)){
            System.out.println("有环");
        }else{
            for (Integer i : tg.order()) {
                sb.append(i + "->");
            }
            sb.delete(sb.length()-2,sb.length());
            System.out.println(sb);
        }
    }
}
