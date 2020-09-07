package algorithm.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

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
        //构建一个并查集对象
        UF_Tree_Weighted uf = new UF_Tree_Weighted(totalNumber);
        //读取第二行数据
        int roadNumber = Integer.parseInt(br.readLine());
        //循环读取7条道路
        for(int i = 1;i<=roadNumber;i++){
            String line = br.readLine();//0 1
            String[] tr = line.split(" ");
            int p = Integer.parseInt(tr[0]);
            int q = Integer.parseInt(tr[1]);
            //调用并查集的union方法让两个城市相通
            uf.union(p,q);
        }
        //获取当前并查集中分组的数量-1就可以得到还需要修建的道路数目
        int roads = uf.count() - 1;
        System.out.println("还需修建的道路数量是：" + roads);
    }
}
