package algorithm.weight_Graph;

public class Edge implements Comparable<Edge> {
    //一个顶点，另一个顶点，两个顶点之间的权重
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //获取边的权重值
    public double getWeight(){
        return weight;
    }

    //获取边上的一个点
    public int either(){
        return v;
    }

    //获取边上除了顶点ver外的另外一个顶点
    public int other(int ver){
        if(ver == v){
            return w;
        }else{
            return v;
        }
    }

    //
    @Override
    //比较权重，如果当前边的权重值大返回1，一样大，返回0，小返回-1；
    public int compareTo(Edge that) {
        if(this.weight<that.weight){
            return 1;
        }else if(this.weight>that.weight){
            return -1;
        }else{
            return 0;
        }
    }
}
