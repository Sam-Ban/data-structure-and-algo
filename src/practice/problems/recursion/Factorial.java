package practice.problems.recursion;

import java.util.Scanner;

/*

 */
public class Factorial {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(Factorial.fact(n));
    }
    private static int fact(int n){
        if(n==0 || n==1)
            return 1;
        else
            return n*fact(n-1);
    }
}
