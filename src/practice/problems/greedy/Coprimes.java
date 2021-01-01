package practice.problems.greedy;

import java.util.Scanner;

public class Coprimes {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=n-2;i>=1;i--) {
            if (Coprimes.isCoprime(i, n) == true) {
                System.out.println(i);
                break;
            }
        }
    }
   private static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);

        return gcd(a, b-a);
    }
    private static boolean isCoprime(int a,int b){
        if(Coprimes.gcd(a,b)==1)
            return true;
        else
            return false;
    }

}
