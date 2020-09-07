package algorithm.tree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String, String> str = new RedBlackTree<String, String>();
        str.put("1","张三");
        str.put("5","张4");
        str.put("6","张8");
        str.put("9","张2");
        str.put("7","张7");
        str.put("2","张1");
        str.put("4","张6");

        String s1 = str.get("5");
        System.out.println(s1);

        String s2 = str.get("2");
        System.out.println(s2);

        String s3 = str.get("4");
        System.out.println(s3);
    }
}
