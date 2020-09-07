package test;

import java.util.Date;

public class jvmTest {
    static class Father{
        public static int A = 2;
        static{
            A = 2;
        }
    }

    static void search(){
        Date dat = new Date();
        int num = 2;
    }

    static class Son extends Father{
        public  static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Son.B);
    }
}
