package test;

import java.util.Scanner;
import java.util.Stack;

public class Main105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            Stack<Character> sta = new Stack<>();
            for(char c:s.toCharArray()){
                sta.push(c);
            }
            while (!sta.isEmpty()){
                System.out.print(sta.pop());
            }
        }
    }
}
