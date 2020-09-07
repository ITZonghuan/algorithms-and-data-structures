package algorithm.priority;

import algorithm.table.linear.Queue;
import algorithm.weight_Graph.DijkstraSP;
import algorithm.weight_Graph.DirectedEdge;
import algorithm.weight_Graph.EdgeWeightedDigraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DijkstraSPTest {
    public static void main(String[] args) throws IOException {
        //创建一副加权有向图
        String load = "E:\\====java_file\\stata_algorithm\\src\\algorithm\\weight_Graph\\DirectRoadTest.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(load)));
        int nodeSum = Integer.parseInt(reader.readLine());
        int edgeSum = Integer.parseInt(reader.readLine());
        //准备一个加权有向图
        EdgeWeightedDigraph eg = new EdgeWeightedDigraph(nodeSum);
        for(int i = 0 ;i<edgeSum;i++){
            String[] s1 = reader.readLine().split(" ");
            int v = Integer.parseInt(s1[0]);
            int w = Integer.parseInt(s1[1]);
            double weight = Double.parseDouble(s1[2]);
            eg.addEdge(new DirectedEdge(v,w,weight));
        }

        //创建DijkstraSP对象，查找最短路径树
        DijkstraSP dsp = new DijkstraSP(eg,0);

        //查找最短路径
        Queue<DirectedEdge> minpath = dsp.pathTo(6);

        //遍历打印
        for (DirectedEdge directedEdge : minpath) {
            System.out.println(directedEdge.from() + "->" + directedEdge.to() + "::" + directedEdge.getWeight());
        }
    }
}
