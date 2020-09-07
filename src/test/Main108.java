package test;

import java.util.Scanner;

public class Main108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int max = Math.max(a,b);
            int n = a * b;
            for(int i=max;i<=n;i++){
                if(i % a == 0 && i % b == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
