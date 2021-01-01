package practice.problems.recursion;

import java.util.Scanner;
import java.util.Stack;

public class FibonacciSeries {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(FibonacciSeries.fib(n));
//if you have to print the series
        Stack<Integer> st = new Stack<>();
       Stack<Integer> stOut = FibonacciSeries.fibo(n,st);
       for(int i=0;i<st.size();i++)
           System.out.println(st.pop());
    }
    private static int fib(int n){
        if(n==0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fib(n-1)+fib(n-2);
    }

    private static Stack<Integer> fibo(int n,Stack<Integer> st){
        if(n==0)
            st.push(0);
        else if(n == 1)
            st.push(1);
        else
            st.push(fib(n-1)+fib(n-2));
        return st;
    }
}
