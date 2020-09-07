package algorithm.symbol;

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> sym = new SymbolTable<Integer, String>();
        sym.put(0,"aa");
        sym.put(1,"bb");
        sym.put(2,"cc");
        sym.put(3,"dd");
        sym.put(2,"ee");

        String str = sym.get(2);
        System.out.println("key为2的值是：" + str);

        sym.delete(0);
        System.out.println("容量为：" + sym.size());

        for (String s : sym) {
            System.out.println(s);
        }
    }
}
