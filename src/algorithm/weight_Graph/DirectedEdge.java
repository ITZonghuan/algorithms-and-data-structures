package algorithm.weight_Graph;

public class DirectedEdge {
    private final int v;
    private final int w;
    private final double weight;
    public DirectedEdge(int v,int w,double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    //获取有向边的起点
    public int from(){
        return v;
    }

    //获取有向边的终点
    public int to(){
        return w;
    }
}
