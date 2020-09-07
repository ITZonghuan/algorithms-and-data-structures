package algorithm.heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap<String> stringHeap = new Heap<String>(10);
        stringHeap.insert("A");
        stringHeap.insert("B");
        stringHeap.insert("C");
        stringHeap.insert("D");
        stringHeap.insert("E");
        stringHeap.insert("F");
        stringHeap.insert("G");
        stringHeap.insert("H");
        stringHeap.insert("I");

        String result = null;
        while((result = stringHeap.delMax())!=null){
            System.out.print(result + " ");
        }
    }
}
