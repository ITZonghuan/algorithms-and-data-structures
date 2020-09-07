package algorithm.Graph;

import algorithm.tree.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Traffic_Project_Test{
    public static void main(String[] args) throws Exception{

        /*
        // 定义一个指向D:/TEXT.TXT 的字节流
        FileInputStream fileInputStream = new FileInputStream("E:\\====java_file\\stata_algorithm\\src\\algorithm\\treetraffic_project.txt");

        //字节流转换成InputStreamReader 
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        //InputStreamReader 转换成带缓存的bufferedReader 
        BufferedReader br = new BufferedReader(inputSteamReader);
        */

        //构建一个缓冲读取流BufferedReader
        String filepath = "E:\\====java_file\\stata_algorithm\\src\\algorithm\\tree\\traffic_project.txt";
        //String filepath = System.getProperty() + "\\traffic_project.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));

        //BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        //读取第一行数据20
        int totalNumber = Integer.parseInt(br.readLine());
        //构建一个Graph对象
        Graph graph = new Graph(totalNumber);
        //UF_Tree_Weighted uf = new UF_Tree_Weighted(totalNumber);
        //读取第二行数据
        int roadNumber = Integer.parseInt(br.readLine());
        //循环读取7条道路
        for(int i = 1;i<=roadNumber;i++){
            String line = br.readLine();//0 1
            String[] tr = line.split(" ");
            int p = Integer.parseInt(tr[0]);
            int q = Integer.parseInt(tr[1]);
            //调用图的addEdge方法让两个城市相通
            graph.addEdge(p,q);
        }
        //构建一个深度优先搜索对象，起点为城市9
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 9);
        System.out.println("9城市是否与10城市相通：" + depthFirstSearch.marked(10));
        System.out.println("9城市是否与8城市相通：" + depthFirstSearch.marked(8));
    }
}
