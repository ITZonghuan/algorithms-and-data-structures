package algorithm.Graph;

import algorithm.table.linear.Queue;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int count;
    //用来存储待搜索邻接表的顶点
    private Queue<Integer> waitSearch;

    public BreadthFirstSearch(Graph G,int s){
        this.marked = new boolean[G.getV()];
        this.count = 0;
        this.waitSearch = new Queue<Integer>();
        bfs(G,s);
    }

    //广度优先算法、此算法有点疑问，似乎仍然是深度优先搜索
    private void bfs(Graph G,int s){
        marked[s] = true;
        count++;
        waitSearch.enqueue(s);
        while (!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            for (Integer w : G.adj(wait)) {
                if(!marked[w]){
                    bfs(G,w);
                }
            }
        }
    }

    //返回与起点相通的顶点个数
    public int getCount(){
        return count;
    }

    //判断顶点w是否与起点相通
    public boolean isLinked(int w){
        return marked[w];
    }
}
