package algorithm.weight_Graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class KruskalMSTest {
    public static void main(String[] args) throws IOException {

        String load = "E:\\====java_file\\stata_algorithm\\src\\algorithm\\weight_Graph\\TestDate.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(load)));
        int nodeSum = Integer.parseInt(reader.readLine());
        int edgeSum = Integer.parseInt(reader.readLine());
        //准备一个加权无向图
        EdgeWeightedGraph eg = new EdgeWeightedGraph(nodeSum);
        for(int i = 0 ;i<edgeSum;i++){
            String[] s1 = reader.readLine().split(" ");
            int v = Integer.parseInt(s1[0]);
            int w = Integer.parseInt(s1[1]);
            double weight = Double.parseDouble(s1[2]);
            eg.addEdge(new Edge(v,w,weight));
        }


        //创建一个KruskalMST对象
        KruskalMST pm = new KruskalMST(eg);
        //获取最小生成树的所有边
        for (Edge edge : pm.mst()) {
            int v = edge.either();
            int w = edge.other(v);
            double weight = edge.getWeight();
            //遍历打印所有的边
            System.out.println(v + "-" + w  + "::" +  weight);
        }

    }
}
