package search.BFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广搜（BFS）一般解决最短路径问题
 * 用队列来存储每一轮遍历得到的节点
 * 队列的初始化用LinkedList
 * 遍历过的节点应该标记
 */
public class leet1091_二进制矩阵中的最短路径 {
    public int shortestPathBinaryMatrix(int[][] grid){
        //边界条件判断
        if(grid == null || grid.length ==0 || grid[0].length == 0) return -1;
        //申请一个队列来解决广搜的最短路径问题
        Queue<Pair<Integer,Integer>> que = new LinkedList<>();
        //二维数组来标识方向问题
        int[][] direction = {{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        //最短路径记录为minPath
        int minPath = 0;
        int m = grid.length;
        int n = grid[0].length;
        //将起点加入队列，并且用new Pair<>(0,0)代表加入的点坐标
        que.add(new Pair<>(0,0));
        //while循环，判断队列是否为空
        while(!que.isEmpty()){
            int size = que.size();
            //走过一步了，路径加1
            minPath++;
            //第二层循环，取出此时队列中的每一个元素，并进行方向判断
            while(size-- > 0){
                Pair<Integer,Integer> pair = que.poll();
                int K = pair.getKey();
                int V = pair.getValue();
                //如果此时格子为1，代表不能走，直接跳过本次循环
                if(grid[K][V] == 1) continue;
                //当到达最后一个点，即目的地时，退出
                if(K == m-1 && V == n-1) return minPath;
                //标记此时的格子为1，代表已经走过
                grid[K][V] = 1;
                //针对取出的格子八个方向分别进行判断
                for(int[] d:direction){
                    int curm = K+d[0],curn = V+d[1];
                    //如果某些方向在范围内，则将此方向上的值加入队列
                    if(curm<0 || curm>=m || curn<0 || curn>=n) continue;
                    que.add(new Pair<>(curm,curn));
                }
            }
        }
        //如果全部循环完，没有返回值，代表不成功，则返回-1
        return -1;
    }
}
