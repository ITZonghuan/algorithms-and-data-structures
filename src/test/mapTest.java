package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,5);
        map.put(1,2);
        map.put(2,0);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        //entries.
        System.out.println(entries);

    }
}
