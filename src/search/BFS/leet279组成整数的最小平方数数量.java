package search.BFS;
/**
 * 此题用动态规划求解更好，转移到动态规划解法
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet279组成整数的最小平方数数量 {
    public int numSquares(int n){
        Queue<Integer> que = new LinkedList<Integer>();
        List<Integer> list = toSquare(n);
        boolean[] isLine = new boolean[n+1];
        que.add(n);
        isLine[n] = true;
        int level = 0;
        while(!que.isEmpty()){
            int size = que.size();
            level++;
            while(size-->0){
                int cur = que.poll();
                for(int num:list){
                    int k = cur - num;
                    if(k < 0){
                        break;
                    }else if(k == 0){
                        return level;
                    }else if(isLine[k]){
                        continue;
                    }else{
                        isLine[k] = true;
                        que.add(k);
                    }
                }
            }
        }
        return n;
    }
    //生成平方数的函数
    private List<Integer> toSquare(int n){
        List<Integer> list = new ArrayList<Integer>();
        int square = 1;
        int sum = 1;
        while(sum <= n){
            list.add(sum);
            square += 2;
            sum += square;
        }
        return list;
    }
}
