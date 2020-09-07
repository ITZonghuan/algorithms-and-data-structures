package algorithm.tree;

import java.util.Scanner;

public class UF_Tree_Test {
    public static void main(String[] args) {
        UF_Tree uf = new UF_Tree(6);
        System.out.println("默认情况下已经存在" + uf.count() +"个元素了");
        //从控制台输入
        Scanner sc = new Scanner(System.in);

        //当不知道要循环多少次的时候就用while(True)
        while (true){
            System.out.println("请输入第一个要合并的元素：");
            int p =sc.nextInt();
            System.out.println("请输入第二个要合并的元素：");
            int q =sc.nextInt();
            if(uf.connected(p,q)){
                System.out.println(p + "元素和" + q +"元素已经存在于一个组中了");
                continue;
            }
            uf.union(p,q);
            System.out.println("当前并查集中还有" + uf.count() + "个分组");
        }
    }
}
