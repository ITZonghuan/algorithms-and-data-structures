package algorithm.symbol;

public class orderSymbolTableTest {
    public static void main(String[] args) {
        orderSymbolTable<Integer, String> sym = new orderSymbolTable<>();
        sym.put(0,"aa");
        sym.put(3,"bb");
        sym.put(2,"cc");
        sym.put(7,"dd");
        sym.put(4,"ee");
        sym.put(6,"ff");

        String str = sym.get(2);
        System.out.println("key为2的值是：" + str);

        sym.delete(6);
        System.out.println("容量为：" + sym.size());

        for (String s : sym) {
            System.out.println(s);
        }
    }
}
