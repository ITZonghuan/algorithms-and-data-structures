package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            String[] str = s.split("\\.");
            int n = str.length;
            if(n != 4) System.out.print("NO");
            int now = 0;
            for(int i=0;i<4;i++){
                int cur = Integer.parseInt(str[i]);
                if(cur < 0 || cur > 255){
                    System.out.print("NO");
                    now = 1;
                }
            }
            if(now == 0){
                System.out.print("YES");
            }
        }
    }
}
