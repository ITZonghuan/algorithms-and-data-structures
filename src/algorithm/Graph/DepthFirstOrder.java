package algorithm.Graph;

import algorithm.table.linear.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    //使用栈，储存顶点序列
    private Stack<Integer> reversePost;

    //构造函数
    public  DepthFirstOrder(DiGraph G){
        this.marked = new boolean[G.getV()];
        this.reversePost = new Stack<Integer>();
        for(int i=0;i<G.getV();i++){
            if(!marked[i]){
                dfs(G,i);
            }
        }
    }

    //基于深度优先搜索，生成顶点线性序列
    private  void dfs(DiGraph G,int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                dfs(G,w);
            }
        }
        reversePost.press(v);
    }

    //获取顶点线性序列·
    public Stack<Integer> reversePost(){
        return reversePost;
    }


}
