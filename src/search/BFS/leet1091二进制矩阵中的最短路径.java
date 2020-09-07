package search.BFS;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS：推导出一个结论：对于先遍历的节点 i 与后遍历的节点 j，有 di <= dj。
 * 利用这个结论，可以求解最短路径等 "最优解" 问题：
 * 第一次遍历到目的节点，其所经过的路径为最短路径。
 * 广度优先搜索做题套路
 * void BFS()
 * {
 *     条件判断；
 *     定义队列;
 *     定义备忘录，用于记录已经访问的位置；
 *     判断边界条件，是否能直接返回结果的。
 *     将起始位置加入到队列中，同时更新备忘录。
 *     while (队列不为空) {
 *         获取当前队列中的元素个数。
 *         for (元素个数) {
 *             取出一个位置节点。
 *             判断是否到达终点位置。
 *             获取它对应的下一个所有的节点。
 *             条件判断，过滤掉不符合条件的位置。
 *             新位置重新加入队列。
 *         }
 *     }
 * }
 */
public class leet1091二进制矩阵中的最短路径 {
    public int shortestPathBinaryMatrix(int[][] grids){
        //第一步：边界判断
        if(grids == null || grids.length == 0 || grids[0].length == 0) return -1;
        //第二步：创建一个方向矩阵
        int[][] direction = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        int m = grids.length,n = grids[0].length;
        //第三步：创建储存容器队列,并加入起点元素
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int pathLength = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            while(size-- > 0){
                Pair<Integer,Integer> cur = queue.poll();
                int cr = cur.getKey(),cc = cur.getValue();
                if(grids[cr][cc] == 1){
                    continue;
                }
                if(cr == m-1 && cc == n-1){
                    return pathLength;
                }
                grids[cr][cc] = 1;//标记
                for(int[] d:direction){
                    int nr = cr + d[0],nc = cc + d[1];
                    if(nr < 0 || nr >= m || nc <0 || nc >= n){
                        continue;
                    }
                    queue.add(new Pair<>(nr,nc));
                }
            }
        }
        return -1;
    }
}
