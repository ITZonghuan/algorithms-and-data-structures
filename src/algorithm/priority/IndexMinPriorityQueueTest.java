package algorithm.priority;

public class IndexMinPriorityQueueTest {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> str = new IndexMinPriorityQueue<>(10);
        str.insert(0,"A");
        str.insert(1,"Q");
        str.insert(3,"O");
        str.insert(5,"R");
        str.insert(2,"F");
        str.insert(4,"B");
        str.insert(7,"D");
        str.insert(9,"C");


        str.changeItem(0,"Z");

        //测试删除
        while(!str.isEmpty()){
            int n = str.delMin();
            String s = str.get(n);
            System.out.print(n + "---" + s + " ");
        }
    }
}
