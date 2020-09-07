package algorithm.Graph;

import algorithm.table.linear.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DepthFirstPathsTest{
    public static void main(String[] args) throws Exception{
        String filepath = "E:\\====java_file\\stata_algorithm\\src\\algorithm\\tree\\traffic_project.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));

        //读取第一行数据20
        int totalNumber = Integer.parseInt(br.readLine());
        //构建一个Graph对象
        Graph graph = new Graph(totalNumber);
        //读取第二行数据
        int roadNum = Integer.parseInt(br.readLine());
        //循环读取7条道路
        for(int i = 1;i<=roadNum;i++){
            String line = br.readLine();//0 1
            String[] tr = line.split(" ");
            int p = Integer.parseInt(tr[0]);
            int q = Integer.parseInt(tr[1]);
            //调用图的addEdge方法让两个城市相通
            graph.addEdge(p,q);
        }

        //起点、终点
        int start = 3;
        int end = 4;
        DepthFirstPaths paths = new DepthFirstPaths(graph, start);

        Stack<Integer> road = paths.pathTo(end);

        StringBuilder sb = new StringBuilder();
        if(paths.hasPathTo(end)){
            System.out.println("3到4是否有路径:" + paths.hasPathTo(end));
            for (Integer i : road) {
                sb.append(i + "->");
            }
            sb.delete(sb.length()-2,sb.length());
            System.out.println(sb);
        }else{
            System.out.println(start + "到" + end +"是否有路径:" + paths.hasPathTo(end));
        }


    }

}
