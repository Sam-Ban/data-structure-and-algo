package practice.problems.binarysearch;

import java.util.Scanner;

/*
You have D dollars with you. You want to put it into a Bank, namely Picu Bank. This bank has a peculiar behavior for interest.
Regardless of the Bank deposit amount, every month it adds A dollars to your bank account and this continues till M months.
Exactly on (M+1) months, it adds B dollars (B<A) to your bank account. This scenario repeats again in same manner.
( i.e on the (M+2)th month A dollars are added, and so on.. ). Your task is to find out how many months does it take for the
dollar amount to reach at least X, in the bank account .

Input:

Input starts with an integer T,(1<=T<=100000) denoting the number of test cases.  Each case starts with 5 integers D,A,M,B and X
as described in problem statement.



Constraints:


Output:

For each case of input minimum number of months needed to reach dollar value of at least X in a single line.

Note that the Expected Output feature of Custom Invocation is not supported for this contest.

SAMPLE INPUT
2
2 5 4 3 51
2 5 4 3 46
SAMPLE OUTPUT
11
10
 */
public class PicuBank {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            long D = s.nextLong();
            long A = s.nextLong();
            long M = s.nextLong();
            long B = s.nextLong();
            long X = s.nextLong();
            // System.out.println(PicuBank.calculateMinMonth(D,A,M,B,X));
            System.out.println(PicuBank.modifiedCalculateMinMonth(A, M, B, X, D));
        }
    }

    //O(n) : Not optimal Solution
    private static int calculateMinMonth(int D, int A, int M, int B, int X) {
        int amount = D;
        int k = 1;
        int count = 0;
        while (true) {
            if (amount <= X) {
                if (k <= M) {
                    amount += A;
                    k++;
                    count++;
                }
                if (k == M + 1) {
                    amount += B;
                    k = 1;
                    count++;
                }
            } else break;
        }
        return count;
    }

    //O(1) : Constant Time complexity : Best Solution
    private static long modifiedCalculateMinMonth(long A, long M, long B, long X, long D) {

        long n = (X - D) / (A * M + B);
        long count = 0;
        count += n * (M + 1);
        long sum = 0;
        long k = (X - D) % (A * M + B);
        if (k != 0) {
            if (A * M < k) {
                count += M + 1;
            } else if (A * M == k) {
                count += M;
            } else {
                count += (k / A);
                if (k % A != 0)
                    count++;
            }
        }
        return count;
    }

}