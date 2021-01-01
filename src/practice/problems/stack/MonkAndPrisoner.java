package practice.problems.stack;
/*
Monk's wizard friend Harry Potter is excited to see his Dad fight Dementors and rescue him and his
Godfather Sirius Black. Meanwhile their friend Hermoine is stuck on some silly arrays problem.
Harry does not have time for all this, so he asked Monk to solve that problem for Hermoine, so that they can go.

The problem is given an array A having N integers, for each i(1<=i<=N), find x+y ,
where x is the largest number less than i such that A[x]>A[i]  and y is the smallest number greater than i
such that A[y]>A[i] . If there is no x<i such that A[x]>A[i], then take x=-1. Similarly, if there is no y>i
such that A[y]>A[i] , then take y=-1.

Input Format:
First line consists of a single integer denoting N.
Second line consists of N space separated integers denoting the array A.

Output Format:
Print N space separated integers, denoting  for each

Constraints: 1<=N<=10^6
1<=A[i]<=10^18


SAMPLE INPUT:
5
5 4 1 3 2

SAMPLE OUTPUT:
-2 0 6 1 3

Explanation
Values of x for each i: -1 1 2 2 4
Values of y for each i: -1 -1 4 -1 -1
So, x+y for each i: -2 0 6 1 3

 */

import java.util.Scanner;

public class MonkAndPrisoner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] inputArr = new int[n];
        MonkAndPrisoner.getInput(inputArr, n, s);
        MonkAndPrisoner.computeSum(inputArr, n);
    }


    static void getInput(int[] inputArr, int n, Scanner s) {
        for (int i = 0; i < n; i++) {
            inputArr[i] = s.nextInt();
        }
    }

    static void computeSum(int[] inputArr, int n) {
        int[] stx = new int[n];
        int[] sty = new int[n];
        for (int i = 0; i < n; i++) {
            int large = Integer.MAX_VALUE;
            int small = Integer.MIN_VALUE;
            for (int x = 0; x < i; x++) {
                if (inputArr[x] > inputArr[i])
                    large = x + 1;

            }
            if (large == Integer.MAX_VALUE)
                stx[i] = -1;
            else
                stx[i] = large;
            for (int y = i + 1; y < n; y++) {
                if (inputArr[y] > inputArr[i]) {
                    small = y + 1;
                    break;
                }

            }
            if (small == Integer.MIN_VALUE)
                sty[i] = -1;
            else
                sty[i] = small;

        }
        for (int i = 0; i < n; i++) {
            System.out.println(stx[i] + sty[i]);
        }
    }
}