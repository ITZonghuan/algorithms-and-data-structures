package algorithm.priority;

public class MinPriorityQueueTest {
    public static void main(String[] args) {
        MinPriorityQueue<String> strmin = new MinPriorityQueue<>(10);
        strmin.insert("A");
        strmin.insert("B");
        strmin.insert("C");
        strmin.insert("D");
        strmin.insert("E");
        strmin.insert("F");
        strmin.insert("G");
        strmin.insert("H");

        while(!strmin.isEmpty()){
            String s = strmin.delMin();
            System.out.print(s + " ");
        }
    }
}
