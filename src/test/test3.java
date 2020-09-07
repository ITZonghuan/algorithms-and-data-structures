package test;

import java.util.Arrays;

public class test3 {
    public static void main(String[] args) {
        String s = "123.632.529.654";
        String[] str = s.split("\\.");
        System.out.println(str.length);
        System.out.println(Arrays.toString(str));
        String s2 = str[1];
        System.out.println(s2.length());
    }
}
