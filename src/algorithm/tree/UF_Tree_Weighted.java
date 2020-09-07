package algorithm.tree;

public class UF_Tree_Weighted {
    //记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;

    //用来储存每一个根结点中树中的个数
    private int[] se;

    public UF_Tree_Weighted(int N){
        //初始化组的个数，默认就是N个组
        this.count = N;
        //初始化数组和组中元素
        this.eleAndGroup = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
        this.se = new int[N];
        for (int i = 0; i < se.length; i++) {
            se[i] = 1;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count(){
        return count;
    }
    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }
    //元素p所在分组的标识符
    public int find(int p){
        while(true){
            if(p == eleAndGroup[p]){
                return p;
            }
            p = eleAndGroup[p];
        }
    }
    //把p元素所在分组和q元素所在分组合并
    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }
        if(se[pRoot] > se[qRoot]){
            eleAndGroup[qRoot] = pRoot;
            se[pRoot]+=se[qRoot];
        }else{
            eleAndGroup[pRoot] = qRoot;
            se[qRoot]+=se[pRoot];
        }
        this.count--;
    }
}
