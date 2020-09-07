package algorithm.priority;

public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue<String> strmax = new MaxPriorityQueue<>(10);
        strmax.insert("A");
        strmax.insert("B");
        strmax.insert("C");
        strmax.insert("D");
        strmax.insert("E");
        strmax.insert("F");
        strmax.insert("G");
        strmax.insert("H");

        while(!strmax.isEmpty()){
            String s = strmax.delMax();
            System.out.print(s + " ");
        }
    }
}
