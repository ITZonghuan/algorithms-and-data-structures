import java.util.HashMap;
import java.util.Map;

public class DIjistra算法解决有权重最短_最长路径 {
    //定义实现功能的函数
    public static void networkDelayTime(int[][] edges, int N, int K) {
        // 构建邻接表，用于存放各个点到各个点的距离
        //节点编号 从 1...N
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = -1;
            }
        }
        //通过矩阵来表示图
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int w = edge[2];
            graph[node1][node2] = w;
        }
        // dis[i] 表示 K节点->i节点的距离
        int[] distance = new int[N + 1];
        boolean[] finish = new boolean[N + 1];
        //候选区
        Map<Integer, Integer> temp = new HashMap<>();  //节点编号,和距离
        temp.put(K, 0);
        while (!temp.isEmpty()) {
            int targetId = getMin(temp);
            int dis = temp.get(targetId);

            distance[targetId] = dis;
            //该点已经遍历过了
            finish[targetId] = true;
            temp.remove(targetId);


            //从选中点发散,然后加入候选区
            for (int i = 1; i <= N; i++) {
                if (finish[i]) continue;
                if (graph[targetId][i] != -1) {
                    Integer newDis = dis + graph[targetId][i];
                    Integer d = temp.get(i);
                    if (d == null) {
                        temp.put(i, newDis);
                    } else {
                        temp.put(i, Math.min(newDis, d));
                    }
                }
            }
        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i <= N; i++) {
//            min = Math.min(min,distance[i]);
//        }
        System.out.println(distance[1]);
    }

    private static int getMin(Map<Integer, Integer> temp) {
        int id = -1;
        int dis = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> kv : temp.entrySet()) {
            if (kv.getValue() < dis) {
                id = kv.getKey();
                dis = kv.getValue();
            }
        }
        //for(Map.Entry<Integer,Integer> kv:temp.entrySet())
        return id;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2, 10}, {2, 3, 50},
                {1, 3, 40},
                {1, 5, 100},
                {1, 4, 30}, {3, 5, 10}, {4, 3, 20}};
        networkDelayTime(edges, 5, 2);
    }
}